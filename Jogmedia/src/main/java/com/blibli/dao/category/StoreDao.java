package com.blibli.dao.category;

import com.blibli.dao.My_Connection;
import com.blibli.dao_api.StoreDaoInterface;
import com.blibli.model.Store;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreDao extends My_Connection implements StoreDaoInterface {
    @Override
    public List<Store> getStore(){
        System.out.println("test1");

        String psql="select * from Store";

        System.out.println("yoy");
        List<Store> temp= new ArrayList<>();
        try{
            this.makeConnection();
            Statement statement=this.con.createStatement();
            ResultSet rs= statement.executeQuery(psql);

            if(rs!=null){
                while (rs.next()) {
                    Store store = new Store(
                            rs.getInt("store_id"),
                            rs.getString("store_name"),
                            rs.getString("address"),
                            rs.getString("npwp"),
                            rs.getString("post_code"),
                            rs.getString("email")
                            );
                    temp.add(store);

                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return temp;
    }
    @Override
    public void insertStore(Store S){
        String psql;
        System.out.println("Apakah masuk insertStore");
        System.out.println(S.getStore_id());
        if(S.getStore_id()!=0){
            psql="UPDATE Store set store_name=?, address=?, npwp=?, post_code=?, email=? where store_id=?";
            try {
                this.makeConnection();
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);

                preparedStatement.setString(1, S.getStore_name());
                preparedStatement.setString(2, S.getAddress());
                preparedStatement.setString(3, S.getNpwp());
                preparedStatement.setString(4, S.getPost_code());
                preparedStatement.setString(5, S.getEmail());
                preparedStatement.setInt(6, S.getStore_id());
                preparedStatement.executeUpdate();
                System.out.println("Sukses update : "+S.getStore_id());
                this.disconnect();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    @Override
    public Store getIdStore(int idStore){
        String psql="Select * from Store where store_id='"+idStore+"';";
        Store store= new Store();
        try{
            this.makeConnection();
            Statement statement= this.con.createStatement();
            ResultSet rs= statement.executeQuery(psql);
            if(rs!=null){
                while (rs.next()) {
                    store.setStore_id(rs.getInt("store_id"));
                    store.setStore_name(rs.getString("store_name"));
                    store.setAddress(rs.getString("address"));
                    store.setNpwp(rs.getString("npwp"));
                    store.setPost_code(rs.getString("post_code"));
                    store.setEmail(rs.getString("email"));
                }
            }
            this.disconnect();
        }catch(Exception e){
            System.out.println(e);
        }
        return store;
    }
}