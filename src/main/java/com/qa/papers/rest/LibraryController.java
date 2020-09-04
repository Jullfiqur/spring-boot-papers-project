package com.qa.papers.rest;

import com.qa.papers.domain.Book;
import com.qa.papers.domain.Library;
import com.qa.papers.service.BookService;
import com.qa.papers.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/getAllLibrarys")
    public List<Library> getAllBooks(){
        return this.libraryService.readAllLibrarys();
    }

    @PostMapping("/createLibrary")
    public Library createLibrary(@RequestBody Library library){
        return this.libraryService.createLibrary(library);
    }

    @DeleteMapping("/deleteLibrary/{id}")
    public Boolean deleteBook(@PathVariable Long id){
        return this.libraryService.deleteLibraryById(id);
    }
/*

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable Long id){
        return this.bookService.findBookById(id);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        return this.bookService.updateBook(id, book);
    }
    @PutMapping("/updateBookWithPathParam")
    public Book updateBookWithPathParam(@PathParam("id") Long id, @RequestBody Book book) {
        // localhost:8080/updateBookWithPathParam?id=1
        return this.bookService.updateBook(id, book);
    }*/
}
