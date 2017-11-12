package com.Jogmedia.Jogmedia.dao.category;

import com.Jogmedia.Jogmedia.dao.My_Connection;
import com.Jogmedia.Jogmedia.dao_api.BookDaoInterface;
import com.Jogmedia.Jogmedia.model.Book;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDao extends My_Connection implements BookDaoInterface{
    @Override
    public List<Book> getAllBooks(){
        String psql="select * from book";
        List<Book> books= new ArrayList<>();
        try{
            this.makeConnection();
            Statement statement= this.con.createStatement();
            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null){
                while(rs.next()){
//int book_id, int category_id, String isbn, String book_title, String author, String publisher, String location, double price_after, double price_before, double discount
                    Book book= new Book(
                            rs.getInt("book_id"),
                            rs.getInt("category_id"),
                            rs.getString("isbn"),
                            rs.getString("book_title"),
                            rs.getString("author"),
                            rs.getString("publisher"),
                            rs.getString("location"),
                            rs.getInt("status"),
                            rs.getDouble("price_before"),
                            rs.getDouble("price_after"),
                            rs.getInt("discount")

                    );
                    books.add(book);
                }
            }
            this.disconnect();
        }catch (Exception e){
            System.out.println(e);
        }
        return books;
    }
    @Override
    public Book getIdBook(int idBook){
        String psql="Select * from Book where book_id='"+idBook+"';";
        Book book= new Book();
        try{
            this.makeConnection();
            Statement statement=this.con.createStatement();
            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null){
                while (rs.next()){
                    book.setBook_id(rs.getInt("book_id"));
                    book.setCategory_id(rs.getInt("category_id"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setBook_title(rs.getString("book_title"));
                    book.setAuthor(rs.getString("author"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setStatus(rs.getInt("status"));
                    book.setPrice_before(rs.getDouble("price_before"));
                    book.setPrice_after(rs.getDouble("price_after"));
                    book.setDiscount(rs.getInt("discount"));
                    book.setLocation(rs.getString("location"));
                }
            }
            this.disconnect();
        }catch (Exception e){
            System.out.println(e);
        }
        return book;
    }

    @Override
    public void saveBook(Book book){
        String psql;
        if(book.getBook_id()!=0){
            System.out.println("updating book");
            psql="UPDATE book SET category_id=?, isbn=?,book_title=?,author=?,publisher=?,status=?,price_before=?,price_after=?,discount=?,location=? where book_id=?";
            try {
                this.makeConnection();
                System.out.println("test update buku");
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                preparedStatement.setInt(1,book.getCategory_id());
                preparedStatement.setString(2,book.getIsbn());
                preparedStatement.setString(3,book.getBook_title());
                preparedStatement.setString(4,book.getAuthor());
                preparedStatement.setString(5,book.getPublisher());
                preparedStatement.setInt(6,book.getStatus());
                preparedStatement.setDouble(7,book.getPrice_before());
                preparedStatement.setDouble(8,book.getPrice_after());
                preparedStatement.setInt(9,book.getDiscount());
                preparedStatement.setString(10,book.getLocation());
                preparedStatement.setInt(11,book.getBook_id());
                preparedStatement.executeUpdate();
                System.out.println("suskes update="+book.getBook_title());
                this.disconnect();

            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            psql = "Insert into book(category_id, isbn, book_title,author,publisher,price_before,price_after,discount,location,status)"+
                    " values (?,?,?,?,?,?,?,?,?,1)";
            try {
                this.makeConnection();
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                System.out.println("berhasil memasukan data buku");

                preparedStatement.setInt(1,book.getCategory_id());
                preparedStatement.setString(2,book.getIsbn());
                preparedStatement.setString(3,book.getBook_title());
                preparedStatement.setString(4,book.getAuthor());
                preparedStatement.setString(5,book.getPublisher());

                preparedStatement.setDouble(6,book.getPrice_before());
                preparedStatement.setDouble(7,book.getPrice_after());
                preparedStatement.setInt(8,book.getDiscount());
                preparedStatement.setString(9,book.getLocation());
                preparedStatement.executeQuery();
                System.out.println("yey berhasil");
                this.disconnect();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
    @Override
    public void deleteBook(int idBook){
        String psql= "Delete from Book where Book.book_id='"+idBook+"';";
        try {
            this.makeConnection();
            Statement statement=this.con.createStatement();
            statement.executeQuery(psql);
            System.out.println("berhasil menghapus data buku");
            this.disconnect();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
