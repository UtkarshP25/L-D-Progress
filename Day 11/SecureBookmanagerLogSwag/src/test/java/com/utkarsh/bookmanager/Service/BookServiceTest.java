package com.utkarsh.bookmanager.Service;

import com.utkarsh.bookmanager.Entity.Book;
import com.utkarsh.bookmanager.Exception.BookNotFoundException;
import com.utkarsh.bookmanager.Repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class BookServiceTest {

    @Mock
     private BookRepository bookRepository;

    @InjectMocks
    private BookService bookServiceTest;

    Book book1, book2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        book1 = new Book(1, "Marvel", "Stan lee");
        book2 = new Book(2, "Romeo Juliet", "William Shakespeare");
    }

    @Test
    void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(List.of(book1, book2));

        ResponseEntity<List<Book>> response = bookServiceTest.getAllBooks();
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testGetBookById_Success() {
        when(bookRepository.findById(1)).thenReturn(Optional.of(book1));

        Book result = bookServiceTest.getBookById(1);
        assertEquals("Marvel", result.getTitle());
    }

    @Test
    void testGetBookById_NotFound() {
        when(bookRepository.findById(3)).thenReturn(Optional.empty());
        assertThrows(BookNotFoundException.class, () -> bookServiceTest.getBookById(3));
    }

    @Test
    void testAddBook(){
        bookServiceTest.addBook(book1);
        verify(bookRepository, times(1)).save(book1);
    }

    @Test
    void testUpdateBook(){
        bookServiceTest.updateBook(1,book1);
        verify(bookRepository).save(book1);
    }

    @Test
    void testDeleteBook(){
        bookServiceTest.deleteBook(1);
        verify(bookRepository).deleteById(1);
    }



}
