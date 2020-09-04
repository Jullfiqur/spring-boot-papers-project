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
    public List<Library> getAllLibrarys(){
        return this.libraryService.readAllLibrarys();
    }

    @PostMapping("/createLibrary")
    public Library createLibrary(@RequestBody Library library){
        return this.libraryService.createLibrary(library);
    }

    @DeleteMapping("/deleteLibrary/{id}")
    public Boolean deleteLibrarys(@PathVariable Long id){
        return this.libraryService.deleteLibraryById(id);
    }

    @GetMapping("/getLibraryById/{id}")
    public Library getLibraryById(@PathVariable Long id){
        return this.libraryService.findLibraryById(id);
    }

    @PutMapping("/updateLibrary/{id}")
    public Library updateLibrary(@PathVariable Long id, @RequestBody Library library){
        return this.libraryService.updateLibrary(id, library);
    }

}
