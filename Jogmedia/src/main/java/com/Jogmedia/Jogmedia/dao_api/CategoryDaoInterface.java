package com.Jogmedia.Jogmedia.dao_api;

import com.Jogmedia.Jogmedia.model.Category;

import java.util.List;

public interface CategoryDaoInterface {
    List<Category> getAllCategory();
    Category getIdCategory(int idCategory);
    void insertCategory(Category C);
    void delete (int id);
}
