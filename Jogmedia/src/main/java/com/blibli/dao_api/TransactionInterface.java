package com.blibli.dao_api;

import com.blibli.model.Book;
import com.blibli.model.Detil_Transaction;
import com.blibli.model.TempDetil;
import com.blibli.model.Transaction;

import java.util.List;

public interface TransactionInterface {

    void saveTransaction(double total,double pembayaran);
    void saveDetailTransaction(Detil_Transaction detil_transaction);
    void deleteDetailTransaction(int idDetil);
    List<Book> searchCashier(String searchKey);
    List<Transaction> getAllTransaction();
    void saveTempDetilTransaction(TempDetil tempDetil);
    void updateTempDetil(double tempUnitPrice, int qty, int id);
    List<TempDetil> getAllTempDetilSaved();
    TempDetil getIdTempDetil(int idTemp);
}
