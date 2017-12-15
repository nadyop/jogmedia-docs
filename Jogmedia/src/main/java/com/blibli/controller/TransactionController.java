package com.blibli.controller;

import com.blibli.model.Book;
import com.blibli.model.TempDetil;
import com.blibli.model.Transaction;
import com.blibli.services.BookService;
import com.blibli.services.CategoryService;
import com.blibli.services.TransactionService;
import com.sun.tracing.dtrace.NameAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TransactionController {
    private final TransactionService transactionService;
    private final BookService bookService;

    @Autowired
    public TransactionController(TransactionService transactionService, BookService bookService) {
        this.transactionService = transactionService;
        this.bookService = bookService;
    }

    @RequestMapping("/transaction")
    public String transaction(Model model ){

        model.addAttribute("tempDetil",transactionService.getAllTempDetil());
        return "transaction";
    }

    @RequestMapping(value = "/transaction/search", method = RequestMethod.GET)
    public String search(Model model, @ModelAttribute("searchKey") String searchKey){
        model.addAttribute("book", transactionService.searchCashier(searchKey));
        return "transaction";
    }
// post = luar kedalam
    @PostMapping(value="/transaction/search/buy/{id}")
    public String search1(@PathVariable("id") Integer id, @ModelAttribute("quantity") Integer quantity){
        Book book = bookService.getIdBuku(id);
        TempDetil tempDetil1= new TempDetil(book.getBook_id(),quantity,book.getPrice_after(), book.getDiscount());

        transactionService.saveDetilTemp(tempDetil1);
        return "redirect:/transaction";
    }

}
