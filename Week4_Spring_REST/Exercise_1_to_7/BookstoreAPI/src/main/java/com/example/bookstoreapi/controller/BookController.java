package com.example.bookstoreapi.controller;
import com.example.bookstoreapi.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(value = "title", required = false) String title,
                                  @RequestParam(value = "author", required = false) String author) {
        return bookList.stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                                (author == null || book.getAuthor().equalsIgnoreCase(author)))
                .toList();
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
//        return bookList.stream()
//                .filter(book -> book.getId().equals(id))
//                .findFirst()
//                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

//    @PostMapping
//    public ResponseEntity<Book> createBook(@RequestBody Book book) {
//        bookList.add(book);
//        return new ResponseEntity<>(book, HttpStatus.CREATED);
//    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  // Custom status for successful creation
    public Book createBook(@RequestBody Book book) {
        bookList.add(book);
        return book;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(book -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("X-Book-Header", "Book retrieved successfully");
                    return new ResponseEntity<>(book, headers, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book updatedBook) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setPrice(updatedBook.getPrice());
                    book.setIsbn(updatedBook.getIsbn());
                    return new ResponseEntity<>(book, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

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
