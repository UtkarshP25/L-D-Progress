package com.utkarsh.bookmanager.controller;

import com.utkarsh.bookmanager.Entity.Book;
import com.utkarsh.bookmanager.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookManagerController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {

        return bookService.getAllBooks();
    }

    @GetMapping("/id/{myid}")
    public Book getBookById(@PathVariable int myid) {

        return bookService.getBookById(myid);
    }

    @PostMapping
    public String addBook(@Valid @RequestBody Book book) {
       bookService.addBook(book);
       return "Book added successfully";
    }

    @PutMapping("/id/{id}")
    public void updateBook(@PathVariable int id, @Valid @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping("id/{myid}")
    public void deleteBook(@PathVariable int myid) {
        bookService.deleteBook(myid);
    }

}
