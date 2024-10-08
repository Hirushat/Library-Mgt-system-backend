package org.example.service;

import org.example.dto.Book;
import org.example.entity.BookEntity;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    List<BookEntity> getBooks();
    boolean deleteBook(Long id);
    Book getBookById(Long id);
    List<BookEntity> getBooksByTitle(String title);
    List<BookEntity> getBooksByCategory(String category);
}
