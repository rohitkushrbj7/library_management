package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(Book book){
        // I Want  to get the authorEntity
        int authorId = book.getAuthor().getId();

        // now i will be fetching the authorEntity

        Author author =authorRepository.findById(authorId).get();

        // Do exception handling;

        // Basic attributes are already set  from postman

        // setting foreign key attribute in child class
        book.setAuthor(author);


        // we need to update list of book return in the parent class
        List<Book> currentBooksWritten =  author.getBooksWritten();
        currentBooksWritten.add(book);
//        author.setBooksWritten(currentBooksWritten);

        //Now the book is to be saved, but also author is also to be saved.

        // why do we need to again  save(update) the author ?? bcz
        //bcz the author Entity has been updated.... we need to resave/update it

        authorRepository.save(author); // Data was modified

        //.save function works both as save function and as update function

        // bookRepo.save is not require  : bcz it will be automatically called by cascading effect
        return "Book Added Successfully";

    }
}
