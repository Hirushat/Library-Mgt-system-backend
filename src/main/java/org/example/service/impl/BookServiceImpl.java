package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    final BookRepository repository;

    ModelMapper mapper;

    @Bean
    public void setMapper(){
        this.mapper = new ModelMapper();
    }

    @Override
    public void addBook(Book book){
        BookEntity entity = mapper.map(book, BookEntity.class);
        repository.save(entity);
    }

    @Override
    public List<BookEntity> getBooks() {
       return repository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Book getBookById(Long id){
        Optional<BookEntity> byId = repository.findById(id);

        return mapper.map(byId, Book.class);
    }

    @Override
    public List<BookEntity> getBooksByTitle(String title) {
        List<BookEntity> books = repository.findAll();
        List<BookEntity> titledBooks = new ArrayList<>();

        for (BookEntity book : books) {
            if(book.getTitle().equalsIgnoreCase(title)){
                titledBooks.add(book);
            }
        }
        return titledBooks;
    }

    @Override
    public List<BookEntity> getBooksByCategory(String category) {
        List<BookEntity> books = repository.findAll();
        List<BookEntity> titledBooks = new ArrayList<>();

        for (BookEntity book : books) {
            if(book.getCategory().equalsIgnoreCase(category)){
                titledBooks.add(book);
            }
        }
        return titledBooks;
    }
}
