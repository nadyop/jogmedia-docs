package com.blibli.controller;

import com.blibli.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransactionController {
    @RequestMapping("/transaction")
    public String transaction(){
        return "transaction";
    }
}
