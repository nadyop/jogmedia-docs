package com.blibli.services;

import com.blibli.dao_api.BookInterface;
import com.blibli.dao_api.CategoryDaoInterface;
import com.blibli.model.Book;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookInterface bookDaoInterface;
    @Autowired
    CategoryDaoInterface categoryDaoInterface;

    public void save(Book book){
        bookDaoInterface.saveBook(book);
    }
    public Model manageFormCreateBook(Model model){
        model.addAttribute("categories", categoryDaoInterface.getAllActive());
        model.addAttribute("book", new Book());
        return model;
    }
    public Model saveModal(Model model, Book book){
        model.addAttribute("categories",categoryDaoInterface.getAllActive());
        model.addAttribute("book", new Book());
    //        model.addAttribute("book",bookDaoInterface.saveBook(book));
        bookDaoInterface.saveBook(book);
        return model;
    }
    public void softDelete(int id){
        bookDaoInterface.softDeleteBook(id);
    }
    public Model showAllListBook(Model model){
        model.addAttribute("book",bookDaoInterface.getAllBooks());
        model.addAttribute("categories", categoryDaoInterface.getAllCategory());
        return model;
    }
    public Model showAllListBookDiscount(Model model){
        model.addAttribute("book",bookDaoInterface.getAllBooksDiscount());
        model.addAttribute("categories", categoryDaoInterface.getAllCategory());
        return model;
    }
    public Model showAllListBookEmpty(Model model){
        model.addAttribute("book",bookDaoInterface.getAllBooksEmty());
        model.addAttribute("categories", categoryDaoInterface.getAllCategory());
        return model;
    }
    public Model manageEditBook(Model model, int idBook){
        model.addAttribute("categories", categoryDaoInterface.getAllActive());
        model.addAttribute("book", bookDaoInterface.getIdBook(idBook));
        return model;
    }
    public Model searchBookByKeyword(Model model, String searchKey){
        model.addAttribute("categories",categoryDaoInterface.getAllActive());
        model.addAttribute("book", bookDaoInterface.search(searchKey));
        return model;
    }
    public Model searchBookByKeywordDiscount(Model model, String searchKey){
        model.addAttribute("categories",categoryDaoInterface.getAllActive());
        model.addAttribute("book", bookDaoInterface.searchDiscount(searchKey));
        return model;
    }
    public Model searchBookByKeywordEmptyStock(Model model, String searchKey){
        model.addAttribute("categories",categoryDaoInterface.getAllActive());
        model.addAttribute("book", bookDaoInterface.searchEmptyBook(searchKey));
        return model;
    }
    private Model validate(Model model, ){

        return model;
    }
}