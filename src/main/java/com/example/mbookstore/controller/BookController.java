package com.example.mbookstore.controller;


import com.example.mbookstore.model.Book;
import com.example.mbookstore.model.BookRepository;
import com.example.mbookstore.model.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    // Handle Login
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    //Show a list of all books
    @RequestMapping("*")
    public String showList(Model model) {
        model.addAttribute("bookList", repository.findAll());
        return "booklist";
    }

    //Delete a book based on the ID
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        repository.deleteById(id);
        System.out.println("Deleted book: " + id);
        return "redirect:/booklist";
    }

    //Load the form to edit a book
    @GetMapping(value = "/editbook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }

    // Load the form to add a book
    @RequestMapping(value = "/addbook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    //saving a book
    @PostMapping("/savebook")
    public String newBook(Book book, Model model){
        repository.save(book);
        System.out.println("Created book:" + book.toString());
        return "redirect:/booklist";
    }

//----------------------------All the REST stuff is down here -----------------------------------

    //RESTful to get all the books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }

    //RESTful to get a book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId);
    }

    //RESTful to search a book/s by title
    @RequestMapping(value="/search/{title}", method = RequestMethod.GET)
    public @ResponseBody List<Book> findTitleRest(@PathVariable("title") String title) {
        return (List<Book>) repository.findByTitle(title);
    }


}