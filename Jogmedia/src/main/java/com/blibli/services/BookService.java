package com.blibli.services;

import com.blibli.dao_api.BookDaoInterface;
import com.blibli.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDaoInterface bookDaoInterface;
    public List<Book> showAllBooks(){
        List<Book> books= bookDaoInterface.getAllBooks();
        return books;
    }
    public void saveOrdUpdateService(Book book){
        bookDaoInterface.saveBook(book);
    }
    public Book getIdBuku(int idBook){
        Book get= bookDaoInterface.getIdBook(idBook);
        return get;
    }
    public void deleteBook(int id){
        bookDaoInterface.deleteBook(id);
    }
}