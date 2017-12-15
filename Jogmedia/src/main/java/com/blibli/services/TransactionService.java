package com.blibli.services;

import com.blibli.dao_api.BookDaoInterface;
import com.blibli.dao_api.TransactionInterface;
import com.blibli.model.Book;
import com.blibli.model.Detil_Transaction;
import com.blibli.model.TempDetil;
import com.blibli.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionInterface transactionInterface;
    @Autowired
    BookDaoInterface bookDaoInterface;
    public void saveOrUpdateTransaction(Transaction transaction){
        transactionInterface.saveTransaction(transaction);
    }
    public void saveOrUpdateDetilTransaction(Detil_Transaction detil_transaction){
        transactionInterface.saveDetailTransaction(detil_transaction);
    }
    public void deleteDetilTransaction(int id){
        transactionInterface.deleteDetailTransaction(id);
    }
    public List<Book> searchCashier(String searchKey){
        List<Book> books= transactionInterface.searchCashier(searchKey);
        return books;
    }
    public void saveDetilTemp(TempDetil tempDetil){
        transactionInterface.saveTempDetilTransaction(tempDetil);
    }
    public List<TempDetil> getAllTempDetil(){
        List<TempDetil> temp= transactionInterface.getAllTempDetilSaved();
        return temp;
    }
}
