package com.blibli.dao_api;

import com.blibli.model.Store;

import java.util.List;

public interface StoreDaoInterface {
    List<Store> getStore();
    void insertStore (Store s);
    Store getIdStore(int idStore);
}