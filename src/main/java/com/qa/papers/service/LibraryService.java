package com.qa.papers.service;

import com.qa.papers.domain.Library;
import com.qa.papers.exceptions.BookNotFoundException;
import com.qa.papers.exceptions.LibraryNotFoundException;
import com.qa.papers.repo.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

        private final LibraryRepository repo;

    @Autowired
    public LibraryService(LibraryRepository repo) {
        this.repo = repo;
    }

    public List<Library> readAllLibrarys(){
        return this.repo.findAll();
    }

    public Library createLibrary(Library library){
        return this.repo.save(library);
    }

    public Library findLibraryById(Long id){
        return this.repo.findById(id).orElseThrow(LibraryNotFoundException::new);
    }

    public Library updateLibrary(Long id, Library library){
        Library update = findLibraryById(id);
        update.setName(library.getName());
        return this.repo.save(update);
    }

    public Boolean deleteLibraryById(Long id){
        if(!this.repo.existsById(id)){
            throw new LibraryNotFoundException();

        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }



}
