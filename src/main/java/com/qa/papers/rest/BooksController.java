package com.qa.papers.rest;

import com.qa.papers.domain.Book;
import com.qa.papers.dto.BookDTO;
import com.qa.papers.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BooksController {


    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(this.bookService.readAllBooks());
    }

    @PostMapping("/createBook")
    public ResponseEntity<BookDTO> createBook(@RequestBody Book book){
        return new ResponseEntity<BookDTO>(this.bookService.createBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        return this.bookService.deleteBookById(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(this.bookService.findBookById(id));

    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody Book book){
        return ResponseEntity.ok(this.bookService.updateBook(id, book));
    }

    @PutMapping("/updateBookWithPathParam")
    public ResponseEntity<BookDTO> updateBookWithPathParam(@PathParam("id") Long id, @RequestBody Book book){
        // localhost:8080/updateBookWithPathParam?id=1
        return ResponseEntity.ok(this.bookService.updateBook(id, book));
    }
}
