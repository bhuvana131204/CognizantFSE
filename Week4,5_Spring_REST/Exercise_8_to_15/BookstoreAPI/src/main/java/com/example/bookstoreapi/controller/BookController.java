package com.example.bookstoreapi.controller;
import com.example.bookstoreapi.model.Book;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import com.example.bookstoreapi.dto.BookDTO;
import org.modelmapper.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
//import javax.validation.constraints.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();
    private final ModelMapper modelMapper;

    public BookController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
    @Operation(summary = "Get all books", description = "Retrieve a list of all books.")
   // @Timed(value = "books.getAll", description = "Time taken to get all books")
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookList.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }
    
    
    @Operation(summary = "Get a book by ID", description = "Retrieve a specific book by its ID.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved book")
    @ApiResponse(responseCode = "404", description = "Book not found")
    @Timed(value = "books.getById", description = "Time taken to get a book by ID")
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long id) {
        Optional<Book> bookOptional = bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
        return bookOptional.map(book -> new ResponseEntity<>(modelMapper.map(book, BookDTO.class), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Timed(value = "books.create", description = "Time taken to create a book")
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        bookList.add(book);
        BookDTO createdBookDTO = modelMapper.map(book, BookDTO.class);
        return new ResponseEntity<>(createdBookDTO, HttpStatus.CREATED);
    }

    @Timed(value = "books.update", description = "Time taken to update a book")
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable("id") Long id, @Valid @RequestBody BookDTO bookDTO) {
        Optional<Book> bookOptional = bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(bookDTO.getAuthor());
            book.setPrice(bookDTO.getPrice());
            book.setIsbn(bookDTO.getIsbn());
            BookDTO updatedBookDTO = modelMapper.map(book, BookDTO.class);
            return new ResponseEntity<>(updatedBookDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Timed(value = "books.delete", description = "Time taken to delete a book")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        boolean removed = bookList.removeIf(book -> book.getId().equals(id));
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
