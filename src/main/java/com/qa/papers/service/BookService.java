package com.qa.papers.service;

import com.qa.papers.domain.Book;
import com.qa.papers.repo.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BooksRepository repo;

    @Autowired
    public BookService(BooksRepository repo) {
        this.repo = repo;
    }

    public List<Book> readAllBooks(){
        return this.repo.findAll();
    }

    public Book createBook(Book book){
        return this.repo.save(book);
    }

    public Book findBookById(Long id){
        return this.repo.findById(id).orElseThrow();
    }
}
