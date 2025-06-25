package com.utkarsh.bookmanager.Service;

import com.utkarsh.bookmanager.Entity.Book;
import com.utkarsh.bookmanager.Exception.BookNotFoundException;
import com.utkarsh.bookmanager.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    public Book getBookById(int id) {

        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
    }

    public ResponseEntity<Void> addBook(Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> updateBook(int id, Book book) {
        BookRepository add = (BookRepository) bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
        add.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteBook(int id) {
        BookRepository delete = (BookRepository) bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));

        delete.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
