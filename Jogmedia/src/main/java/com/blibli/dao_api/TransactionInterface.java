package com.blibli.dao_api;

import com.blibli.model.Detil_Transaction;
import com.blibli.model.Transaction;

public interface TransactionInterface {
    void saveTransaction(Transaction transaction);
    void saveDetailTransaction(Detil_Transaction detil_transaction);
    void deleteDetailTransaction(int idDetil);
}
