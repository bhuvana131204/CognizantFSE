package com.library.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;



public class LibraryApplication {
    public static void main(String[] args) {
        // Initialize the context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and use the beans
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.displayService();

        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        bookRepository.displayRepository();
        
        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
