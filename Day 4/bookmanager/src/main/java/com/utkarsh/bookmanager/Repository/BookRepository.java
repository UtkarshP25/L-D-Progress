package com.utkarsh.bookmanager.Repository;

import com.utkarsh.bookmanager.Entity.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {

    public Map<Integer, Book> bookMap = new HashMap<>();

}
