package com.qa.papers.rest;
import com.qa.papers.domain.Book;
import com.qa.papers.service.BookService;
import com.qa.papers.domain.Library;
import com.qa.papers.dto.LibraryDTO;
import com.qa.papers.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<LibraryDTO>> getAllLibrarys(){
        return ResponseEntity.ok(this.libraryService.readAllLibrarys());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/createLibrary")
    public ResponseEntity<LibraryDTO> createLibrary(@RequestBody Library library){
        return new ResponseEntity<LibraryDTO>(this.libraryService.createLibrary(library), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteLibrary/{id}")
    public Boolean deleteLibrarys(@PathVariable Long id){
        return this.libraryService.deleteLibraryById(id);
    }

    @GetMapping("/getLibraryById/{id}")
    public ResponseEntity<LibraryDTO> getLibraryById(@PathVariable Long id){
        return ResponseEntity.ok(this.libraryService.findLibraryById(id));
    }

    @PutMapping("/updateLibrary/{id}")
    public ResponseEntity<LibraryDTO> updateLibrary(@PathVariable Long id, @RequestBody Library library){
        return ResponseEntity.ok(this.libraryService.updateLibrary(id, library));
    }

}
