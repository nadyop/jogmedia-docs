package com.Jogmedia.Jogmedia.dao_api;

import com.Jogmedia.Jogmedia.model.Store;

import java.util.List;

public interface StoreDaoInterface {
    List<Store> getStore();
    void insertStore (Store s);
    Store getIdStore(int idStore);
}
