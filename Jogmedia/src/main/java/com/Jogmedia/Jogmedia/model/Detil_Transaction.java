package com.Jogmedia.Jogmedia.model;

public class Detil_Transaction {
    private int detil_id, quantity;
    private Integer discountDetil;
    private double unit_price;

    public Detil_Transaction(int detil_id, int quantity, Integer discountDetil, double unit_price) {
        this.detil_id = detil_id;
        this.quantity = quantity;
        this.discountDetil = discountDetil;
        this.unit_price = unit_price;
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
}
