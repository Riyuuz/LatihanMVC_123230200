/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rakha
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class koneksikan implements koneksiINT {
    String jdbc = "com.mysql.cj.jdbc.Driver";
    String dbName = "library_db";
    String url = "jdbc:mysql://localhost:3306/" + dbName;
    String usrn = "root";
    String pw = "";
    
    Connection conn;
    
    public koneksikan (){
        try {
            Class.forName(jdbc);
            conn = DriverManager.getConnection(url,usrn,pw);
            System.out.println("AaH!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public List<buku> getbuku(){
        List<buku> result = null;
        try {
            result = new ArrayList();
            Statement sta = conn.createStatement();
            String que = "SELECT * FROM books";
            ResultSet rs = sta.executeQuery(que);
            while(rs.next()){
                buku nb = new buku();
                nb.id = rs.getInt("id");
                nb.judul = rs.getString("judul");
                nb.penulis = rs.getString("penulis");
                nb.tahun = rs.getInt("tahun_terbit");
                nb.alur = rs.getInt("alur");
                nb.bahasa = rs.getInt("gaya");
                nb.ori = rs.getInt("orisinalitas");
                nb.rating = rs.getFloat("rating");
                
                result.add(nb);
            }
        } catch (Exception e) {
            
        }
        return result;
    }
    
    @Override
    public void insertBuku (buku datas){
        try {
            String Qu = "INSERT INTO books(judul,penulis,tahun_terbit,alur,gaya,orisinalitas,rating) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps;
            ps = conn.prepareStatement(Qu);
            ps.setString(1, datas.judul);
            ps.setString(2, datas.penulis);
            ps.setInt(3, datas.tahun);
            ps.setInt(4, datas.alur);
            ps.setInt(5, datas.bahasa);
            ps.setInt(6, datas.ori);
            ps.setFloat(7, datas.rating);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }
    
    @Override
    public void UpdateBuku (buku datas){
         String Qu2 = "UPDATE books SET judul = ?,penulis =?,tahun_terbit=?,alur=?,gaya=?,orisinalitas=?,rating=? WHERE ID = ?";
        try {
            PreparedStatement sss;
            sss = conn.prepareStatement(Qu2);
            sss.setString(1, datas.judul);
            sss.setString(2, datas.penulis);
            sss.setInt(3, datas.tahun);
            sss.setInt(4, datas.alur);
            sss.setInt(5, datas.bahasa);
            sss.setInt(6, datas.ori);
            sss.setFloat(7, datas.rating);
            sss.setInt(8, datas.id);
            sss.executeUpdate();
            sss.close();
        } catch (Exception e) {
            System.out.println("salah" + e.getMessage());
        }
        
    }
    
    @Override
    public void deletion(int id)
     {
         String Qu3 = "DELETE FROM books WHERE id = ?";
         try {
             PreparedStatement sss;
             sss = conn.prepareStatement(Qu3);
             sss.setInt(1, id);
             sss.executeUpdate();
             sss.close();
         } catch (Exception e) {
         }
     }
    
    
    
    
}
      
