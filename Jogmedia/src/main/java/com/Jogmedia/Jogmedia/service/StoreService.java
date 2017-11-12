package com.Jogmedia.Jogmedia.service;

import com.Jogmedia.Jogmedia.dao_api.StoreDaoInterface;
import com.Jogmedia.Jogmedia.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    StoreDaoInterface storeDaoInterface;
    public List<Store> showStore(){
        List<Store> data=storeDaoInterface.getStore();
        return data;
    }
    public void saveOrUpdate(Store store){
        storeDaoInterface.insertStore(store);
    }
    public Store getIdStore(Integer id){
        Store get= storeDaoInterface.getIdStore(id);
        return get;
    }
}
