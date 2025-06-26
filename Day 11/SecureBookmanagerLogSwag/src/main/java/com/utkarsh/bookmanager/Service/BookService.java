package com.utkarsh.bookmanager.Service;

import com.utkarsh.bookmanager.Entity.Book;
import com.utkarsh.bookmanager.Exception.BookNotFoundException;
import com.utkarsh.bookmanager.Repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public ResponseEntity<List<Book>> getAllBooks() {
        log.debug("Request : getAllBooks()");
        List<Book> books = bookRepository.findAll();
        log.info("Fetched {} books", books.size());
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    public Book getBookById(int id) {

        log.debug("Request : getBookById({})", id);

        return bookRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Book with id {} not found", id);
                    return new BookNotFoundException("Book with id " + id + " not found");
        });
    }

    public ResponseEntity<Void> addBook(Book book) {
        log.debug("Request : addBook(title='{}')", book.getTitle());
        bookRepository.save(book);
        log.info("Book created with id {}", book.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> updateBook(int id, Book book) {
        log.debug("Request : updateBook({})", id);
        BookRepository add = (BookRepository) bookRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Book with id {} not found for update", id);
                    return new BookNotFoundException("Book with id " + id + " not found");
                });
        add.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteBook(int id) {
        log.debug("Request : deleteBook(id={})", id);

        if (!bookRepository.existsById(id)) {
            log.warn("Book with id {} not found for delete", id);
            throw new BookNotFoundException("Book with id " + id + " not found");
        }

        bookRepository.deleteById(id);
        log.info("Book id {} deleted", id);
        return ResponseEntity.noContent().build();
    }

}
