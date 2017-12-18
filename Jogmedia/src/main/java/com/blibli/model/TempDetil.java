package com.blibli.model;

public class TempDetil {

    private Integer bookId, employee_id;
    private double unitPrice;
    private Integer quantity, discount, id_detil;
    private String book_title, isbn;
    public TempDetil(Integer id_detil,Integer bookId, Integer quantity,Double unitPrice,  Integer discount, String book_title, String isbn, int employee_id) {
        this.id_detil=id_detil;
        this.bookId = bookId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
        this.book_title=book_title;
        this.isbn=isbn;
        this.employee_id=employee_id;
    }

    public TempDetil() {
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getId_detil() {
        return id_detil;
    }

    public void setId_detil(Integer id_detil) {
        this.id_detil = id_detil;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
