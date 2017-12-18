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
import java.util.ArrayList;
import java.util.List;

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
         double temp=0;

        List<TempDetil> tempDetils = transactionService.getAllTempDetil();
        for (TempDetil tempDetil : tempDetils)  {
            temp += (double) (tempDetil.getQuantity() * tempDetil.getUnitPrice());
            System.out.println("nilai:"+tempDetil.getQuantity());
            System.out.println("nilai:"+tempDetil.getUnitPrice());
        }
        System.out.println("hasil"+temp);
        model.addAttribute("total",temp);
        return "transaction";
    }

    @RequestMapping(value = "/transaction/search", method = RequestMethod.GET)
    public String search(Model model, @ModelAttribute("searchKey") String searchKey){
        model.addAttribute("tempDetil",transactionService.getAllTempDetil());
        model.addAttribute("book", transactionService.searchCashier(searchKey));
        double temp=0;

        List<TempDetil> tempDetils = transactionService.getAllTempDetil();
        for (TempDetil tempDetil : tempDetils)  {
            temp += (double) (tempDetil.getQuantity() * tempDetil.getUnitPrice());
            System.out.println("nilai:"+tempDetil.getQuantity());
            System.out.println("nilai:"+tempDetil.getUnitPrice());
        }
        System.out.println("hasil"+temp);
        model.addAttribute("total",temp);
        return "transaction";
    }

// post = luar kedalam
// get= dalam keluar
    @PostMapping(value="/transaction/search/buy/{id}")
    public String search1(@PathVariable("id") Integer id, @ModelAttribute("quantity") Integer quantity){

        Book book = bookService.getIdBuku(id);
        TempDetil tempDetilTemp= transactionService.getIdTempDetilService(id);
        System.out.println("id book"+tempDetilTemp.getBookId());
        if(tempDetilTemp.getBookId()!=null && book.getStok()>=quantity)
        {
            System.out.println("updating");
            quantity += tempDetilTemp.getQuantity();
            System.out.println("quantity="+quantity);
        //    tempDetilTemp = setTempDetil(tempDetilTemp.getId_detil(), tempDetilTemp.getBookId(),quantity,tempDetilTemp.getUnitPrice(),tempDetilTemp.getDiscount(),tempDetilTemp.getBook_title(),tempDetilTemp.getIsbn(),tempDetilTemp.getEmployee_id());

            transactionService.updatingTempDetil(tempDetilTemp.getUnitPrice(),quantity, tempDetilTemp.getId_detil());

        }
        else if(tempDetilTemp.getBookId()==null && book.getStok()>=quantity)
        {
            TempDetil tempDetil1= new TempDetil(id, book.getBook_id(),quantity,book.getPrice_after(), book.getDiscount(),book.getBook_title(),book.getIsbn(),1);
            transactionService.saveDetilTemp(tempDetil1);
        }
        else{
            System.out.println("quantity diatas stok");
        }
        return "redirect:/transaction";
    }
    private TempDetil setTempDetil( double price,int qty){
        TempDetil tempDetil= new TempDetil();


        tempDetil.setQuantity(qty);
        tempDetil.setUnitPrice(price);

        return tempDetil;
    }
//    private TempDetil setTempDetil(int id, int book_id, int qty, double price, int disc, String book_title, String isbn, int employee_id){
//        TempDetil tempDetil= new TempDetil();
//        tempDetil.setId_detil(id);
//        tempDetil.setBookId(book_id);
//        tempDetil.setQuantity(qty);
//        tempDetil.setUnitPrice(price);
//        tempDetil.setDiscount(disc);
//        tempDetil.setBook_title(book_title);
//        tempDetil.setIsbn(isbn);
//        tempDetil.setEmployee_id(employee_id);
//        return tempDetil;
//    }
    //TempDetil tempDetil1= new TempDetil(id, book.getBook_id(),quantity,book.getPrice_after(), book.getDiscount(),book.getBook_title(),book.getIsbn(),1);
    @RequestMapping(value = "/transaction/hapus/{id}",method = RequestMethod.GET)
    public String hapusDataCategory(@PathVariable Integer id,Model model){
        transactionService.deleteDetilTransaction(id);
        return "redirect:/transaction";
    }

}
