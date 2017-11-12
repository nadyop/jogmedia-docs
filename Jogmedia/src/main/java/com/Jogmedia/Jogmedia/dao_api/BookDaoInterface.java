package com.Jogmedia.Jogmedia.dao_api;

import com.Jogmedia.Jogmedia.model.Book;

import java.util.List;

public interface BookDaoInterface {
    List<Book> getAllBooks();

    Book getIdBook(int idBook);
    void saveBook(Book book);
    void deleteBook(int idBook);
}
