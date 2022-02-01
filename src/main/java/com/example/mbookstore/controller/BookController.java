package com.example.mbookstore.controller;

import com.example.mbookstore.dao.DatabaseApi;
import com.example.mbookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    DBService dbservice;
    @Autowired
    DatabaseApi dbApi;
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("bookList", dbservice.getData());
        return "index";
    }
    @GetMapping(value = "/deletebook/{booktitle}")
    public String details(@PathVariable String booktitle, Model model) {
        System.out.println("booktitle" + booktitle);
        dbApi.deleteRecord(booktitle);
        model.addAttribute("bookList", dbservice.getData());
        return "index";  //TODO: I need to put a redirect here return "redirect:/index";
    }
}