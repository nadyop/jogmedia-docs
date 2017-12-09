package com.blibli.controller;

import com.blibli.model.Transaction;
import com.blibli.services.BookService;
import com.blibli.services.CategoryService;
import com.blibli.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @RequestMapping("/transaction")
    public String transaction(){
        return "transaction";
    }

    @RequestMapping(value = "/transaction/search", method = RequestMethod.POST)
    public String search(Model model, @ModelAttribute("searchKey") String searchKey){
        model.addAttribute("book", transactionService.searchCashier(searchKey));
        return "transaction";
    }
}
