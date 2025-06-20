package com.utkarsh.bookmanager.Repository;

import com.utkarsh.bookmanager.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    //public Map<Integer, Book> bookMap = new HashMap<>();

}
