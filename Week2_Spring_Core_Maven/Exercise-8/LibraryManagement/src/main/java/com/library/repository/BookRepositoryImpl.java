package com.library.repository;
import org.springframework.stereotype.Repository;


@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public void displayRepository() {
        System.out.println("BookRepositoryImpl implementation");
    }
}
