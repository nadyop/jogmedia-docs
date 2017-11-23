package com.blibli.dao.category;

import com.blibli.dao.My_Connection;
import com.blibli.dao_api.CategoryDaoInterface;
import com.blibli.model.Category;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDao extends My_Connection implements CategoryDaoInterface {


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
                System.out.println("test1");
                System.out.println("getAll\t:");
                while (rs.next()){
                    System.out.println("\t"+rs.getInt("category_id"));
                    Category category= new Category(
                            rs.getInt("category_id"),
                            rs.getString("category_name"),
                            rs.getString("category_desc"),
                            rs.getInt("status")
                    );
                    list.add(category);
                    System.out.println(category.getStatus());
                }
            }
            this.disconnect();
        }
        catch (Exception e){
            System.out.println("eror "+ e);
        }
        return list;
    }

    @Override
    public List<Category> search(String searchKey) {
        String psql="select * from category where category_name='"+searchKey+"' ORDER BY category_id";
        List<Category> categories= new ArrayList<>();
        System.out.println(searchKey);
        try {
            this.makeConnection();
            Statement statement = this.con.createStatement();
            PreparedStatement preparedStatement= this.con.prepareStatement(psql);
            ResultSet rs = statement.executeQuery(psql);
            if (rs != null) {
                while (rs.next()) {
                    Category category= new Category(
                            rs.getInt("category_id"),
                            rs.getString("category_name"),
                            rs.getString("category_desc"),
                            rs.getInt("status")
                    );
                    categories.add(category);
                }
            }
            this.disconnect();
        }catch (Exception e){
            System.out.println(e);
        }
        return categories;
    }

    @Override
    public Category getIdCategory(int idCategory){
        String psql="Select * from category where category_id='"+idCategory+"';";
        Category category= new Category();
        try {
            System.out.println("test3");
            this.makeConnection();
            Statement statement= this.con.createStatement();
            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null){
                while (rs.next()){
                    System.out.println("getId: "+rs.getInt("category_id"));
                    category.setCategory_id(rs.getInt("category_id"));
                    category.setCategory_name(rs.getString("category_name"));
                    category.setCategory_desc(rs.getString("category_desc"));
                    category.setStatus(rs.getInt("status"));
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
        String psql;
        System.out.println("test4");
        if(C.getCategory_id()!=0){
            System.out.println("masuk update");
            psql="UPDATE category SET category_name =?, category_desc=?, status=? where category_id=?";

            try{
                this.makeConnection();
                System.out.println("test1");

                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                preparedStatement.setString(1,C.getCategory_name());
                preparedStatement.setString(2,C.getCategory_desc());
                preparedStatement.setInt(3,C.getStatus());
                preparedStatement.setInt(4,C.getCategory_id());
                preparedStatement.executeUpdate();
                System.out.println("Sukses update : "+C.getCategory_id());
                this.disconnect();
            }
            catch (Exception e){
                System.out.println(e);

            }
        }
        else{
            psql = "Insert into category(category_name, category_desc, status)" +
                    "values (?,?,1)";
            try{
                this.makeConnection();
                System.out.println("berhasil insert data");
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                preparedStatement.setString(1,C.getCategory_name());
                preparedStatement.setString(2,C.getCategory_desc());

                preparedStatement.executeQuery();
                System.out.println("berhasil insert data");
                this.disconnect();

            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println("masuk insert");
        }



    }
    @Override
    public void delete (int id){
        String psql= "Delete from Category where Category.category_id='"+id+"';";
        try{
            System.out.println("test5");
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