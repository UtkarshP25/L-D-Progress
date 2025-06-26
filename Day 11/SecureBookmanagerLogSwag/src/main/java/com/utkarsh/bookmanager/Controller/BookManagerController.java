package com.utkarsh.bookmanager.Controller;

import com.utkarsh.bookmanager.Entity.Book;
import com.utkarsh.bookmanager.Service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Book Manager")
@RestController
@RequestMapping("/books")
public class BookManagerController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Get all books", description = "Returns a list of all available books")
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        return bookService.getAllBooks();
    }

    @Operation(summary = "Get book by ID", description = "Returns a book by its unique ID")
    @GetMapping("/id/{myid}")
    public Book getBookById(@PathVariable int myid) {

        return bookService.getBookById(myid);
    }

//    @GetMapping("/csrf-token")
//    public CsrfToken getCsrfToken(HttpServletRequest request) {
//        return (CsrfToken) request.getAttribute("_csrf");
//    }

    @Operation(summary = "Add new book", description = "Adds a new book to the collection")
    @PostMapping
    public String addBook(@Valid @RequestBody Book book) {
       bookService.addBook(book);
       return "Book added successfully";
    }

    @Operation(summary = "Update book by ID", description = "Updates an existing book by ID")
    @PutMapping("/id/{id}")
    public void updateBook(@PathVariable int id, @Valid @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @Operation(summary = "Delete book by ID", description = "Deletes a book by ID")
    @DeleteMapping("id/{myid}")
    public void deleteBook(@PathVariable int myid) {
        bookService.deleteBook(myid);
    }

}
