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
    public List<Book> findall() {
        return bookService.getAllBooks();
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<Book> findbyid(@PathVariable int myid) {
        return bookService.getBookById(myid);
    }

    @PostMapping
    public String addBook(@Valid @RequestBody Book book) {
       bookService.save(book);
       return "Book added successfully";
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @Valid @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("id/{myid}")
    public ResponseEntity<Book> deleteBook(@PathVariable int myid) {
        return bookService.deleteBook(myid);
    }

}
