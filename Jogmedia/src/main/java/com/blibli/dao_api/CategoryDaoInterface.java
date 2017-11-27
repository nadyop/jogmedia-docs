package com.blibli.dao_api;

import com.blibli.model.Book;
import com.blibli.model.Category;

import java.util.List;

public interface CategoryDaoInterface {
    List<Category> getAllCategory();
    List<Category> search(String searchKey);
    Category getIdCategory(int idCategory);
    void insertCategory(Category C);
    void delete (int id);

}