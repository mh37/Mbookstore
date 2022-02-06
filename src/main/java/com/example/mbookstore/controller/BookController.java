package com.example.mbookstore.controller;


import com.example.mbookstore.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("bookList", repository.findAll());
        return "index";
    }
    @GetMapping(value = "/deletebook/{booktitle}")
    public String deleteBook(@PathVariable String booktitle, Model model) {
        System.out.println("Deleting booktitle" + booktitle);
        //dbApi.deleteRecord(booktitle);
        model.addAttribute("bookList", repository.findAll());
        return "redirect:/index";
    }

    @GetMapping(value = "/editbook/{booktitle}")
    public String editBook(@PathVariable String booktitle, Model model) {
        System.out.println("Updating booktitle" + booktitle);
        //dbApi.deleteRecord(booktitle);
        model.addAttribute("bookList", repository.findAll());
        return "edit_book";
    }

    @GetMapping(value = "/newbook")
    public String newBook(Model model) {
        model.addAttribute("bookList", repository.findAll());
        return "new_book";
    }
}