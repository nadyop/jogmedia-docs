package com.blibli.controller;

import com.blibli.model.Store;
import com.blibli.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;

    @RequestMapping("/store")
    public String dataStore(Model model){
        model.addAttribute("store",storeService.showStore());
        return "store";
    }
    @RequestMapping(value = "/store/",method = RequestMethod.GET)
    public String tampilFormStore(Model model){
        model.addAttribute("store",new Store());
        return "store";
    }
    @RequestMapping(value = "/store/createStore",method = RequestMethod.GET)
    public String simpanDataStore(Store store){
        storeService.saveOrUpdate(store);
        return "createStore";
    }
    @RequestMapping(value = "/store/edit/{id}", method = RequestMethod.GET)
    public String editDataStore(@PathVariable Integer id, Model model){
        model.addAttribute("store",storeService.getIdStore(id));
        return "createStore";
    }
}