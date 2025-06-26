package com.utkarsh.bookmanager.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utkarsh.bookmanager.Entity.Book;
import com.utkarsh.bookmanager.Service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookManagerController.class)
public class BookManagerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;



    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGetAllBooks() throws Exception {
        List<Book> books = List.of(
                new Book(1, "Marvel", "Stan lee"),
                new Book(2, "Romeo Juliet", "William Shakespeare")
        );

        when(bookService.getAllBooks()).thenReturn(ResponseEntity.ok(books));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testGetBookById() throws Exception {
        Book book1 = new Book(1, "Marvel", "Stan lee");
        when(bookService.getBookById(1)).thenReturn(book1);

        mockMvc.perform(get("/books/id/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Marvel"));
    }


    @Test
    void testAddBook() throws Exception {
        Book book1 = new Book(1, "Marvel", "Stan lee");

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book1)))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateBook() throws Exception {
        Book book1 = new Book(1, "Marvel", "Stan lee");

        mockMvc.perform(put("/books/id/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book1)))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/books/id/1"))
                .andExpect(status().isOk());
    }
}



