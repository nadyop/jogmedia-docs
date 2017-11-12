package com.Jogmedia.Jogmedia.controller;

import com.Jogmedia.Jogmedia.model.Book;
import com.Jogmedia.Jogmedia.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/book")
    public String BookList(Model model){
        model.addAttribute("book",bookService.showAllBooks());
        return "book";
    }
    @RequestMapping(value="/book/createBook",method = RequestMethod.POST)
    public String simpanDataBook(Model model, Book buku){
        bookService.saveOrdUpdateService(buku);
        return "redirect:/book";
    }
    @RequestMapping(value = "/book/createBook", method = RequestMethod.GET)
    public String tampilFormCreateBook(Model model){
        model.addAttribute("book", new Book());
        return "createBook";
    }
    @RequestMapping(value = "/book/editBook/{id}",method = RequestMethod.GET)
    public String editDataCategory(@PathVariable Integer id, Model model){
        model.addAttribute("book",bookService.getIdBuku(id));
        return "createBook";
    }
    @RequestMapping(value = "/book/hapus/{id}", method = RequestMethod.GET)
    public String hapusDataBuku(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }
}
