package com.utkarsh.springdemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class democlass {

    @GetMapping("abc")
    public String show(){
        return "Hello World";
    }
}
