package com.libraryApp.WebAppLibrary.repository;

import com.libraryApp.WebAppLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Book, Integer> {
}
