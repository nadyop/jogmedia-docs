package com.blibli.dao.category;

import com.blibli.dao.My_Connection;
import com.blibli.dao_api.BookDaoInterface;
import com.blibli.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDao extends My_Connection implements BookDaoInterface {

    @Override
    public List<Book> getAllBooks(){
        String psql="select * from book ";
        List<Book> books= new ArrayList<>();
        try{
            this.makeConnection();
            Statement statement= this.con.createStatement();

            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null){
                while(rs.next()){
                    Book book= new Book(
                            rs.getInt("book_id"),
                            rs.getInt("category_id"),
                            rs.getString("isbn"),
                            rs.getString("book_title"),
                            rs.getString("author"),
                            rs.getString("publisher"),
                            rs.getString("location"),
                            rs.getInt("discount"),
                            rs.getDouble("price_before"),
                            rs.getDouble("price_after"),
                            rs.getInt("stok"),
                            rs.getInt("status")
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
    public List<Book> getAllBooksDiscount(){
        String psql="select * from book where book.discount!=0 and book.stok!=0";
        List<Book> books= new ArrayList<>();
        try{
            this.makeConnection();
            Statement statement= this.con.createStatement();

            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null){
                while(rs.next()){

                    Book book= new Book(
                            rs.getInt("book_id"),
                            rs.getInt("category_id"),
                            rs.getString("isbn"),
                            rs.getString("book_title"),
                            rs.getString("author"),
                            rs.getString("publisher"),
                            rs.getString("location"),
                            rs.getInt("discount"),
                            rs.getDouble("price_before"),
                            rs.getDouble("price_after"),
                            rs.getInt("stok"),
                            rs.getInt("status")

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
    public List<Book> getAllBooksEmty(){
        String psql="select * from book where book.stok=0 ";
        List<Book> books= new ArrayList<>();
        try{
            this.makeConnection();
            Statement statement= this.con.createStatement();

            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null){
                while(rs.next()){

                    Book book= new Book(
                            rs.getInt("book_id"),
                            rs.getInt("category_id"),
                            rs.getString("isbn"),
                            rs.getString("book_title"),
                            rs.getString("author"),
                            rs.getString("publisher"),
                            rs.getString("location"),
                            rs.getInt("discount"),
                            rs.getDouble("price_before"),
                            rs.getDouble("price_after"),
                            rs.getInt("stok"),
                            rs.getInt("status")

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
    public  List<Book> search(String searchKey){

        String test="'%"+searchKey+"%'";
        String psql="select * from book where LOWER(book_title) LIKE LOWER('%" + searchKey+ "%')   ORDER BY book_id";
        List<Book> books= new ArrayList<>();
        System.out.println(searchKey);

        try {
            this.makeConnection();
            Statement statement = this.con.createStatement();
            PreparedStatement preparedStatement= this.con.prepareStatement(psql);

            ResultSet rs = statement.executeQuery(psql);

            if (rs != null) {
                while (rs.next()) {
                    Book book= new Book(
                            rs.getInt("book_id"),
                            rs.getInt("category_id"),
                            rs.getString("isbn"),
                            rs.getString("book_title"),
                            rs.getString("author"),
                            rs.getString("publisher"),
                            rs.getString("location"),
                            rs.getInt("discount"),
                            rs.getDouble("price_before"),
                            rs.getDouble("price_after"),
                            rs.getInt("stok"),
                            rs.getInt("status")
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
                    book.setLocation(rs.getString("location"));
                    book.setDiscount(rs.getInt("discount"));
                    book.setPrice_before(rs.getDouble("price_before"));
                    book.setPrice_after(rs.getDouble("price_after"));
                    book.setStok(rs.getInt("stok"));
                    book.setStatus(rs.getInt("status"));
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
        double hitung;

        if(book.getBook_id()!=0){
            System.out.println("updating book");
            psql="UPDATE book SET isbn=?,book_title=?,author=?,publisher=?,category_id=?,location=?,price_before=?,price_after=?,discount=?, stok=?,status=? where book_id=?";
            try {
                this.makeConnection();
                System.out.println("test update buku");
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                preparedStatement.setString(1,book.getIsbn());
                preparedStatement.setString(2,book.getBook_title());
                preparedStatement.setString(3,book.getAuthor());
                preparedStatement.setString(4,book.getPublisher());
                preparedStatement.setInt(5,book.getCategory_id());
                preparedStatement.setString(6,book.getLocation());
                preparedStatement.setDouble(7,book.getPrice_before());
                hitung=(book.getPrice_before()-(book.getPrice_before()*(book.getDiscount()/100.0)));

                preparedStatement.setDouble(8,hitung);
                preparedStatement.setInt(9,book.getDiscount());
                preparedStatement.setInt(10,book.getStok());
                preparedStatement.setInt(11,book.getStatus());
                preparedStatement.setInt(12,book.getBook_id());
                preparedStatement.executeUpdate();
                System.out.println("suskes update="+book.getBook_title());
                this.disconnect();

            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            psql = "Insert into book(category_id, isbn, book_title,author,publisher,price_before,price_after,discount,location,stok,status)"+
                    " values (?,?,?,?,?,?,?,?,?,?,1)";
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
                hitung=(book.getPrice_before()-(book.getPrice_before()*(book.getDiscount()/100.0)));
                preparedStatement.setDouble(7,hitung);
                preparedStatement.setInt(8,book.getDiscount());
                preparedStatement.setString(9,book.getLocation());
                preparedStatement.setInt(10,book.getStok());
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