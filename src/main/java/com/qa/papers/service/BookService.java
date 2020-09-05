package com.qa.papers.service;

import com.qa.papers.domain.Book;
import com.qa.papers.dto.BookDTO;
import com.qa.papers.exceptions.BookNotFoundException;
import com.qa.papers.repo.BooksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BooksRepository repo;

    private final ModelMapper mapper;


    @Autowired
    public BookService(BooksRepository repo, ModelMapper mapper) {

        this.repo = repo;
        this.mapper = mapper;
    }

    private BookDTO mapToDTO(Book book){
        return this.mapper.map(book, BookDTO.class);
    }

    public List<BookDTO> readAllBooks(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public BookDTO createBook(Book book){
        return this.mapToDTO(this.repo.save(book));
    }

    public BookDTO findBookById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(BookNotFoundException::new));
    }

    public BookDTO updateBook(Long id, Book book){
        Book update = this.repo.findById(id).orElseThrow(BookNotFoundException::new);
        update.setTitle(book.getTitle());
        update.setDescription(book.getDescription());
        return this.mapToDTO(this.repo.save(book));
    }

    public Boolean deleteBookById(Long id){
        if(!this.repo.existsById(id)){
            throw new BookNotFoundException();

        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
