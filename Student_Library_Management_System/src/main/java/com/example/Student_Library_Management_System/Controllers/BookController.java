package com.example.Student_Library_Management_System.Controllers;


import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {


    @Autowired
    BookService bookService;


    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
          return bookService.addBook(book);
    }
}
