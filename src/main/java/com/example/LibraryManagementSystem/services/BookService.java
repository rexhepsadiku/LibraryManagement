package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.models.Book;
import com.example.LibraryManagementSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks() {
        List<Book> book = new ArrayList<Book>();
        bookRepository.findAll().forEach(book::add);
        return book;
    }
    public Book getBookById(long id){return bookRepository.findById(id).get();}
    public void saveBook(Book book){bookRepository.save(book);}
    public void updateBook(Book book) {bookRepository.save(book);}
    public void deleteBook(long id){bookRepository.deleteById(id);}
    public Page<Book> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return bookRepository.findAll(pageable);
    }
}
