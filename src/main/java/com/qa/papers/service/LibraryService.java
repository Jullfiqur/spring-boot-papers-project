package com.qa.papers.service;

import com.qa.papers.repo.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

        private final LibraryRepository repo;

    @Autowired
    public LibraryService(LibraryRepository repo) {
        this.repo = repo;
    }


}
