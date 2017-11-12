package com.Jogmedia.Jogmedia.dao.category;

import com.Jogmedia.Jogmedia.dao.My_Connection;
import com.Jogmedia.Jogmedia.dao_api.StoreDaoInterface;
import com.Jogmedia.Jogmedia.model.Store;
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
        String psql="select * from Store";
        List<Store> temp= new ArrayList<>();
        try{
            this.makeConnection();
            Statement statement=this.con.createStatement();
            ResultSet rs= statement.executeQuery(psql);
            System.out.println("testGEGE2  cute ");
            if(rs!=null){
                while (rs.next()) {
                    Store store = new Store(
                            rs.getInt("store_id"),
                            rs.getInt("employee_id"),
                            rs.getString("store_name"),
                            rs.getString("address"),
                            rs.getString("npwp"),
                            rs.getString("post_code"),
                            rs.getString("email"),
                            rs.getString("image")
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
        if(S.getStore_id()!=0){
            psql="UPDATE Store set employee_id=?,store_name=?, address=?, npwp=?, post_code=?, email=?, image=? where store_id=?";
            try {
                this.makeConnection();
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);

                preparedStatement.setInt(1, S.getEmployee_id());
                preparedStatement.setString(2, S.getStore_name());
                preparedStatement.setString(3, S.getAddress());
                preparedStatement.setString(4, S.getNpwp());
                preparedStatement.setString(5, S.getPost_code());
                preparedStatement.setString(6, S.getEmail());
                preparedStatement.setString(7, S.getImage());
                preparedStatement.setInt(8,S.getStore_id());
                preparedStatement.executeUpdate();
                System.out.println("Sukses update : "+S.getStore_id());
                this.disconnect();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else {
            System.out.println("testGEGE3");
            psql="INSERT INTO store(employee_id, store_name, address, npwp, post_code, email, image) VALUES (?,?,?,?,?,?,?,?)";
            try{
                System.out.println("testGEGE1");
                this.makeConnection();
                System.out.println("berhasil insert data");
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                preparedStatement.setInt(1,S.getStore_id());
                preparedStatement.setInt(2, S.getEmployee_id());
                preparedStatement.setString(3, S.getStore_name());
                preparedStatement.setString(4, S.getAddress());
                preparedStatement.setString(5, S.getNpwp());
                preparedStatement.setString(6, S.getPost_code());
                preparedStatement.setString(7, S.getEmail());
                preparedStatement.setString(8, S.getImage());
                preparedStatement.executeUpdate();
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
                    store.setEmployee_id(rs.getInt("employee_id"));
                    store.setStore_name(rs.getString("store_name"));
                    store.setAddress(rs.getString("address"));
                    store.setNpwp(rs.getString("npwp"));
                    store.setPost_code(rs.getString("post_code"));
                    store.setEmail(rs.getString("email"));
                    store.setImage(rs.getString("image"));
                }
            }
            this.disconnect();
        }catch(Exception e){
            System.out.println(e);
        }
        return store;
    }
}
