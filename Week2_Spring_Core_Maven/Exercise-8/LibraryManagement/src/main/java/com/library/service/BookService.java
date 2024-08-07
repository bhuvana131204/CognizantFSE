package com.library.service;

import com.library.repository.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
    	this.bookRepository = bookRepository;
    }
    
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayService() {
        System.out.println("BookService is using " + bookRepository);
        bookRepository.displayRepository();
    }
}
