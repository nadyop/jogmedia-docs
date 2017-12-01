package com.blibli.services;

import com.blibli.dao_api.TransactionInterface;
import com.blibli.model.Detil_Transaction;
import com.blibli.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionInterface transactionInterface;
    public void saveOrUpdateTransaction(Transaction transaction){
        transactionInterface.saveTransaction(transaction);
    }
    public void saveOrUpdateDetilTransaction(Detil_Transaction detil_transaction){
        transactionInterface.saveDetailTransaction(detil_transaction);
    }
    public void deleteDetilTransaction(int id){
        transactionInterface.deleteDetailTransaction(id);
    }
}
