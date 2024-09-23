package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    final BookService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.FOUND)
    public List<BookEntity> getBooks(){
       return service.getBooks();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        if (service.deleteBook(id)){
            return "Deleted Book";
        }else{
            return "Not Found";
        }

    }


}
