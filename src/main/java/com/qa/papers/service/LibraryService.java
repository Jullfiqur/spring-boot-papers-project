package com.qa.papers.service;

import com.qa.papers.domain.Library;
import com.qa.papers.dto.LibraryDTO;
import com.qa.papers.exceptions.BookNotFoundException;
import com.qa.papers.exceptions.LibraryNotFoundException;
import com.qa.papers.repo.LibraryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public LibraryService(LibraryRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private LibraryDTO mapToDTO(Library library){
        return this.mapper.map(library, LibraryDTO.class);
    }

    public List<LibraryDTO> readAllLibrarys(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public LibraryDTO createLibrary(Library library){
        return this.mapToDTO(this.repo.save(library));
    }

    public LibraryDTO findLibraryById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(LibraryNotFoundException::new));
    }

    public LibraryDTO updateLibrary(Long id, Library library){
        Library update = this.repo.findById(id).orElseThrow(LibraryNotFoundException::new);
        update.setName(library.getName());
        return this.mapToDTO(this.repo.save(update));
    }

    public Boolean deleteLibraryById(Long id){
        if(!this.repo.existsById(id)){
            throw new BookNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }



}
