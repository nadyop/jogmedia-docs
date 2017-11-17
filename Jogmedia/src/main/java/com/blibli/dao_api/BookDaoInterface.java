package com.blibli.dao_api;

import com.blibli.model.Book;

import java.util.List;

public interface BookDaoInterface {
    List<Book> getAllBooks();
<<<<<<< HEAD
//    List<Book> searchkey();

=======
    List<Book> search(String searchKey);
>>>>>>> 581a15b897439375f649cf4a46e0925d07548eae
    Book getIdBook(int idBook);
    void saveBook(Book book);
    void deleteBook(int idBook);
}
