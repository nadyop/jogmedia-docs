package com.Jogmedia.Jogmedia.dao.category;

import com.Jogmedia.Jogmedia.dao.My_Connection;
import com.Jogmedia.Jogmedia.dao_api.dao_inteface;
import com.Jogmedia.Jogmedia.model.Category;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDao extends My_Connection implements dao_inteface {


    @Override
    public List<Category> getAllCategory() {
        String psql="select * from Category";
        System.out.println("Show Category");
        List<Category> list= new ArrayList<>();
        try{
            this.makeConnection();
            Statement statement=this.con.createStatement();
            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null){
                System.out.println("getAll\t:");
                while (rs.next()){
                    System.out.println("\t"+rs.getInt("category_id"));
                    Category category= new Category(
                            rs.getInt("category_id"),
                            rs.getString("category_name"),
                            rs.getString("category_desc")
                    );
                    list.add(category);
                }
            }
            this.disconnect();
        }
        catch (Exception e){
            System.out.println("error get All Category");
            System.out.println(e);
        }
        return list;
    }
    @Override
    public  void updateCategory(Category C){
        String psql="Update category SET category_name =?, category_desc=?  where category_id=?";
        try{
            this.makeConnection();
            PreparedStatement preparedStatement= this.con.prepareStatement(psql);
            preparedStatement.setString(1,C.getCategory_name());
            preparedStatement.setString(2,C.getCategory_desc());
            preparedStatement.executeQuery();
            System.out.println("Sukses update data: "+C.getCategory_id());
            this.disconnect();
        }
        catch (Exception e){
            System.out.println("Error while updating category");
            System.out.println(e);
        }

    }

    @Override
    public Category getIdCategory(int idCategory){
        String psql="Select * from category where category_id='"+idCategory+"';";
        Category category= new Category();
        try {
            this.makeConnection();
            Statement statement= this.con.createStatement();
            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null){
                while (rs.next()){
                    System.out.println("getId: "+rs.getInt("category_id"));
                    category.setCategory_id(rs.getInt("category_id"));
                    category.setCategory_name(rs.getString("category_name"));
                    category.setCategory_desc(rs.getString("category_desc"));
                }
            }
            this.disconnect();

        }
        catch (Exception e){
            System.out.println(e);
        }
        return category;
    }
    @Override
    public void insertCategory(Category C){
        String psql ="Insert into category(category_name, category_desc)"+
                "values (?,?)";
        try{
            this.makeConnection();
            PreparedStatement preparedStatement= this.con.prepareStatement(psql);
            preparedStatement.setString(1,C.getCategory_name());
            preparedStatement.setString(2,C.getCategory_desc());
            preparedStatement.executeQuery();
            this.disconnect();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public void delete (int id){
        String psql= "Delete from Category where category_id'"+id+"';";
        try{
            this.makeConnection();
            Statement statement= this.con.createStatement();
            statement.executeQuery(psql);
            this.disconnect();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

