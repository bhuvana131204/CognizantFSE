package com.library.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class LibraryApplication {
    public static void main(String[] args) {
        // Initialize the context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        try {
            // Retrieve and use the beans
            BookService bookService = (BookService) context.getBean("bookService");
            bookService.displayService();

            BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
            bookRepository.displayRepository();
        } finally {
            // Close the context to release resources
            if (context instanceof ClassPathXmlApplicationContext) {
                ((ClassPathXmlApplicationContext) context).close();
            }
        }
    }
}
