package com.qa.papers.rest;

import com.qa.papers.domain.Book;
import com.qa.papers.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> getAllBooks(){
        return this.bookService.readAllBooks();
    }

    @PostMapping("/createBook")
    public Book createBook(@RequestBody Book book){
        return this.bookService.createBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteBook(@PathVariable Long id){
        return this.bookService.deleteBookById(id);
    }

}
