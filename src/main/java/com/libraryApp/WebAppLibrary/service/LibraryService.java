package com.libraryApp.WebAppLibrary.service;

import com.libraryApp.WebAppLibrary.model.Book;
import com.libraryApp.WebAppLibrary.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public void addBook(Book book){
        libraryRepository.save(book);
    }

    public void deleteBook(int id){
        libraryRepository.deleteById(id);

    }

    public boolean checkAvailability(int id){
        return libraryRepository.findById(id)
                .map(Book::isAvailable)
                .orElse(false);
    }

    public List<Book> allBooks(){
        return libraryRepository.findAll();
    }
}
