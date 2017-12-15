package com.blibli.dao_api;

import com.blibli.model.Book;
import com.blibli.model.Detil_Transaction;
import com.blibli.model.TempDetil;
import com.blibli.model.Transaction;

import java.util.List;

public interface TransactionInterface {

    void saveTransaction(Transaction transaction);
    void saveDetailTransaction(Detil_Transaction detil_transaction);
    void deleteDetailTransaction(int idDetil);
    List<Book> searchCashier(String searchKey);
    void saveTempDetilTransaction(TempDetil tempDetil);
    List<TempDetil> getAllTempDetilSaved();

}
