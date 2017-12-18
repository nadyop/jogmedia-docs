package com.blibli.dao.category;

import com.blibli.dao.My_Connection;
import com.blibli.dao_api.TransactionInterface;
import com.blibli.model.Book;
import com.blibli.model.Detil_Transaction;
import com.blibli.model.TempDetil;
import com.blibli.model.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionDao extends My_Connection implements TransactionInterface {
    @Override
    public List<Transaction> getAllTransaction(){
        String psql="select transaction_id from transaction";
        List<Transaction> transactions= new ArrayList<>();
        try{
            this.makeConnection();
            Statement statement= this.con.createStatement();

            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null) {
                while (rs.next()) {
                    Transaction transaction= new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getInt(null),
                        rs.getDouble(null),
                        rs.getDouble(null),
                        rs.getDate(null)
                    );
                    transactions.add(transaction);
                }
            }
            this.disconnect();
        }catch (Exception e){
            System.out.println(e);
        }
        return  transactions;
    }
    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
    @Override
    public void saveTransaction(double total,double pembayaran){
        String psql;

        psql = "Insert into transaction(employee_id,total_pembelian,total_pembayaran,tanggal_transaksi)"+
                " values (1,'"+total+"','"+pembayaran+"',CURRENT_DATE)";
        try {
            this.makeConnection();

            PreparedStatement preparedStatement= this.con.prepareStatement(psql);
            preparedStatement.setInt(1,1);
            preparedStatement.setDouble(2,total);
            preparedStatement.setDouble(3,pembayaran);
            preparedStatement.setDate(4, getCurrentDate());
            preparedStatement.executeUpdate();
            this.disconnect();

        }catch (Exception e){
            System.out.println(e);
        }

    }
    @Override
    public void saveDetailTransaction(Detil_Transaction detil){
        String psql;

            psql = "Insert into detil_transaction(transaction_id,book_id,quantity,unit_price, discount)"+
                    " values (?,?,?,?,?)";
            try {
                this.makeConnection();
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                preparedStatement.setInt(1,detil.getTransaction_id());
                preparedStatement.setInt(2,detil.getBook_id());
                preparedStatement.setInt(3,detil.getQuantity());
                preparedStatement.setDouble(4,detil.getUnit_price());
                preparedStatement.setInt(5,detil.getDiscountDetil());
                preparedStatement.executeUpdate();
                this.disconnect();
            }catch (Exception e){
                System.out.println(e);
            }

    }
    @Override
    public void deleteDetailTransaction(int idDetil){
        String psql= "Delete from temp_detil where id_detil='"+idDetil+"';";
        try {
            this.makeConnection();
            Statement statement=this.con.createStatement();
            statement.executeQuery(psql);
            System.out.println("berhasil menghapus data detil");
            this.disconnect();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public List<Book> searchCashier(String searchKey) {
        String psql="select * from book where  status=1 AND stok!=0 AND  LOWER(isbn) LIKE LOWER('%" + searchKey+ "%') ORDER BY book_id";
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
    public void updateTempDetil(double tempUnitPrice, int qty, int id){
        String psql;
        System.out.println("unitPrice"+tempUnitPrice+"quantity="+qty+"ID="+id);
        psql = "Update temp_Detil SET quantity=?, unit_price=? where id_detil=?";

        try {
            this.makeConnection();
            PreparedStatement preparedStatement= this.con.prepareStatement(psql);
            preparedStatement.setInt(1,qty);

            preparedStatement.setDouble(2,tempUnitPrice);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
            this.disconnect();

        }catch (Exception e){
            System.out.println(e);
        }

    }
    @Override
    public void saveTempDetilTransaction(TempDetil tempDetil){
        String psql;

        psql = "Insert into temp_Detil(book_id, quantity, unit_price, discount, employee_id)"+
                " values (?,?,?,?,?)";
        try {
            this.makeConnection();
            PreparedStatement preparedStatement= this.con.prepareStatement(psql);
            preparedStatement.setInt(1,tempDetil.getBookId());
            preparedStatement.setInt(2,tempDetil.getQuantity());
            preparedStatement.setDouble(3,tempDetil.getUnitPrice());
            preparedStatement.setInt(4,tempDetil.getDiscount());
            preparedStatement.setInt(5,1);
            preparedStatement.executeUpdate();
            this.disconnect();

        }catch (Exception e){
            System.out.println(e);
        }

    }
    @Override
    public List<TempDetil> getAllTempDetilSaved(){
        String psql=" select id_detil,book.isbn,temp_detil.book_id, quantity, unit_price, temp_detil.discount, book_title, employee_id from temp_detil join book using(book_id)";
        List<TempDetil> temp = new ArrayList<>();
        try {
            this.makeConnection();
            Statement statement= this.con.createStatement();
            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null) {
                while (rs.next()) {

                    TempDetil tempDetil= new TempDetil(
                            rs.getInt("id_detil"),
                            rs.getInt("book_id"),
                            rs.getInt("quantity"),
                            rs.getDouble("unit_price"),
                            rs.getInt("discount"),
                            rs.getString("book_title"),
                            rs.getString("isbn"),
                            rs.getInt("employee_id")
                    );
                    temp.add(tempDetil);
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return  temp;
    }
    @Override
    public TempDetil getIdTempDetil(int idTemp){
        String psql=" select id_detil,book.isbn,temp_detil.book_id, quantity, unit_price, temp_detil.discount, book_title, employee_id from temp_detil join book using(book_id) where temp_detil.book_id='"+idTemp+"';";
        TempDetil tempDetil= new TempDetil();
        try{
            this.makeConnection();
            Statement statement=this.con.createStatement();
            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null) {
                while (rs.next()) {
                    tempDetil.setId_detil(rs.getInt("id_detil"));
                    tempDetil.setBookId(rs.getInt("book_id"));
                    tempDetil.setQuantity(rs.getInt("quantity"));
                    tempDetil.setUnitPrice(rs.getDouble("unit_price"));
                    tempDetil.setDiscount(rs.getInt("discount"));
                    tempDetil.setBook_title(rs.getString("book_title"));
                    tempDetil.setIsbn(rs.getString("isbn"));
                    tempDetil.setEmployee_id(rs.getInt("employee_id"));

                }
            }
            this.disconnect();
        }catch (Exception e){
            System.out.println(e);
        }
        return  tempDetil;
    }
}
