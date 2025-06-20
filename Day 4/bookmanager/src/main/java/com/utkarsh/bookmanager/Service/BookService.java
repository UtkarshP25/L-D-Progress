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


    public List<Book> getAllBooks() {
        return new ArrayList<>(bookRepository.bookMap.values());
    }

    public ResponseEntity<Book> getBookById(int id) {

        //Optional<Book> book = Optional.ofNullable(bookRepository.bookMap.get(id));
        Book book = Optional.ofNullable(bookRepository.bookMap.get(id))
                .orElseThrow(() -> new BookNotFoundException("Book with id" + id + "not found"));

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public ResponseEntity<Book> save(Book book) {
        try{
            bookRepository.bookMap.put(book.getId(), book);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Book> updateBook(int id, Book book) {
        if(bookRepository.bookMap.containsKey(id)) {
            Optional.ofNullable(bookRepository.bookMap.put(id, book));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Book> deleteBook(int id) {
        bookRepository.bookMap.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
