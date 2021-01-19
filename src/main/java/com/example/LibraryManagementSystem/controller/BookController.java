package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.models.Book;
import com.example.LibraryManagementSystem.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping("")
    public String getAllBooks(Model model) {
        return findPaginated(1,model);
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Book getOne(Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/add")
    public String addNewBook(Book getbooks){
        bookService.saveBook(getbooks);
        return "redirect:/books";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateBook(Book book){
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteBook(Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value="pageNo") int pageNo, Model model) {
        int pageSize = 6;
        Page<Book> page = bookService.findPaginated(pageNo,pageSize);
        List<Book> listBooks = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("books",listBooks);
        return "books";
    }
}
