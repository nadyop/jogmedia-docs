package com.blibli.controller;

import com.blibli.model.Book;
import com.blibli.services.BookService;
import com.blibli.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/book")
    public String BookList(Model model){
        model.addAttribute("book",bookService.showAllBooks());
        return "book";
    }
    @RequestMapping("/discount")
    public String BookListDiscount(Model model){
        model.addAttribute("book",bookService.showAllBooksbyDiscount());
        return "book";
    }
    @RequestMapping("/emptyStok")
    public String BookListEmpty(Model model){
        model.addAttribute("book",bookService.showAllBooksbyEmptyStok());
        return "book";
    }
    @RequestMapping(value="/book/",method = RequestMethod.POST)
    public String simpanDataBook(Model model, @ModelAttribute("buku") Book buku){
        bookService.saveOrdUpdateService(buku);
        return "redirect:/book";
    }
    @RequestMapping(value = "/book/createBook", method = RequestMethod.GET)
    public String tampilFormCreateBook(Model model){
        model.addAttribute("categories", categoryService.showAllCategory());
        model.addAttribute("book", new Book());
        return "createBook";
    }
    @RequestMapping(value = "/book/editBook/{id}",method = RequestMethod.GET)
    public String editDataCategory(@PathVariable Integer id, Model model){
        model.addAttribute("categories", categoryService.showAllCategory());
        model.addAttribute("book",bookService.getIdBuku(id));
        return "createBook";
    }
    @RequestMapping(value = "/book/search", method = RequestMethod.POST)
    public String search(Model model, @ModelAttribute("searchKey") String searchKey){
        model.addAttribute("book", bookService.searchBook(searchKey));
        return "book";
    }
    @RequestMapping(value = "/book/hapus/{id}", method = RequestMethod.GET)
    public String hapusDataBuku(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }
}
