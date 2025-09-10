package com.libraryApp.WebAppLibrary.controller;

import com.libraryApp.WebAppLibrary.model.Book;
import com.libraryApp.WebAppLibrary.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/books")
    public String home(){
        return "library";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Book book, Model model){
        libraryService.addBook(book);
        model.addAttribute("books", libraryService.allBooks());
        return "redirect:/books/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, Model model){
        libraryService.deleteBook(id);
        model.addAttribute("books", libraryService.allBooks());
        return "redirect:/books/list";
    }

    @GetMapping("/list")
    public String listBooks(Model model){
        model.addAttribute("books", libraryService.allBooks());
        return "library";
    }

    @GetMapping("/library-check")
    public String checkAvail(@RequestParam int id, Model model){
        boolean avail=libraryService.checkAvailability(id);
        model.addAttribute("availability",avail ? "Book is available":"Book is not available");
        model.addAttribute("books", libraryService.allBooks());
        return "library";
    }
}
