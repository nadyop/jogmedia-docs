package com.blibli.model;

import java.util.Date;

public class Transaction {
    private Integer transaction_id, employee_id;
    private Date tanggal;
    private double total_pembelian, total_pembayaran;

    public Transaction(int transaction_id, int employee_id, double total_pembelian, double total_pembayaran, Date tanggal) {
        this.transaction_id = transaction_id;
        this.tanggal = tanggal;
        this.total_pembelian = total_pembelian;
        this.total_pembayaran = total_pembayaran;
        this.employee_id=employee_id;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public double getTotal_pembelian() {
        return total_pembelian;
    }

    public void setTotal_pembelian(double total_pembelian) {
        this.total_pembelian = total_pembelian;
    }

    public double getTotal_pembayaran() {
        return total_pembayaran;
    }

    public void setTotal_pembayaran(double total_pembayaran) {
        this.total_pembayaran = total_pembayaran;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }
}