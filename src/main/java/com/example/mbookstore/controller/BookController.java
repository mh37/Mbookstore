package com.example.mbookstore.controller;


import com.example.mbookstore.model.Book;
import com.example.mbookstore.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    //Show a list of all books
    @RequestMapping("/booklist")
    public String showList(Model model) {
        model.addAttribute("bookList", repository.findAll());
        return "booklist";
    }

    //Delete a book based on the ID
    @GetMapping(value = "/deletebook/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        repository.deleteById(id);
        System.out.println("Deleted book: " + id);
        return "redirect:/booklist";
    }

    //Load the form to edit a book
    @GetMapping(value = "/editbook/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        System.out.println("Updating Book" + id);
        Optional<Book> book = repository.findById(id);
        model.addAttribute("book", book);
        return "editbook";
    }

    @PostMapping("/updatebook")
    public String updateBook(Book book, Model model) {
        repository.save(book);
        System.out.println("Updated Book " + book.getId() + "New Values: " +book.toString());
        return "redirect:/booklist";
    }


    //Load the form to create a new book
    @GetMapping(value = "/addbook")
    public String addBook(Book book, Model model) {
        return "addbook";
    }

    //Creating and saving a new book
    @PostMapping("/newbook")
    public String newBook(Book book, Model model){
        repository.save(book);
        System.out.println("Created book:" + book.toString());
        return "redirect:/booklist";
    }
}