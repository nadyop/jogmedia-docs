package com.blibli.model;

public class Detil_Transaction {
    private int detil_id, quantity;
    private Integer discountDetil;
    private Integer transaction_id;
    private Integer book_id;
    private Integer employee_id;
    private double unit_price;

    public Detil_Transaction(int transaction_id,int book_id,int detil_id, int quantity, Integer discountDetil, double unit_price, int employee_id) {
        this.detil_id = detil_id;
        this.quantity = quantity;
        this.discountDetil = discountDetil;
        this.unit_price = unit_price;
        this.transaction_id=transaction_id;
        this.book_id=book_id;
        this.employee_id=employee_id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public int getDetil_id() {
        return detil_id;
    }

    public void setDetil_id(int detil_id) {
        this.detil_id = detil_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getDiscountDetil() {
        return discountDetil;
    }

    public void setDiscountDetil(Integer discountDetil) {
        this.discountDetil = discountDetil;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }
}
