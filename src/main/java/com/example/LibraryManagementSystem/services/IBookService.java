package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.models.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(long id);
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBook(long id);
    Page<Book> findPaginated(int pageNo, int pageSize);
}
