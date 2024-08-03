/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.Constant;
import DTO.KhoHangDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KhoHangDAO implements DAOInterface<KhoHangDTO>{
	private String dbUrl = Constant.dbUrl;
        private String username = Constant.username;
        private String password = Constant.password;
    private Connection con;
    
    public boolean openConnection(){
        try{
            
            con = DriverManager.getConnection(dbUrl, username, password);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public void closeConnection(){
        try{
            if(con!=null)
                con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public ArrayList<KhoHangDTO> getAll(){
        ArrayList<KhoHangDTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String query = "SELECT * FROM khohang WHERE trangthai = 1";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    KhoHangDTO khoHang = new KhoHangDTO();
                    khoHang.setMaKho(rs.getString(1));
                    khoHang.setTenKho(rs.getString(2));
                    khoHang.setDiachi(rs.getString(3));
                    khoHang.setSdt(rs.getString(4));
                    
                    arr.add(khoHang);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    @Override
    public boolean has(String makho){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "SELECT * FROM khohang WHERE makhohang = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, makho);
                ResultSet rs = ps.executeQuery();
                result = rs.next();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    @Override
    public boolean add(KhoHangDTO khohang){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "INSERT INTO khohang VALUES (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, khohang.getMaKho());
                ps.setString(2, khohang.getTenKho());
                ps.setString(3, khohang.getDiachi());
                ps.setString(4, khohang.getSdt());
                ps.setInt(5, 1);
                if(ps.executeUpdate()>0)
                    return true;
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    @Override
    public boolean delete(String makho){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "UPDATE khohang SET trangthai = 0 WHERE makhohang = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, makho);
                if(ps.executeUpdate()>0)
                    return true;
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    @Override
    public boolean update(KhoHangDTO khohang){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "UPDATE khohang SET tenkhohang = ?, diachi = ?, sdt = ? WHERE makhohang = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, khohang.getTenKho());
                ps.setString(2, khohang.getDiachi());
                ps.setString(3, khohang.getSdt());
                ps.setString(4, khohang.getMaKho());
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    @Override
    public KhoHangDTO getByID(String makho){
        KhoHangDTO khohang = null;
        return khohang;
    }
    
    @Override
    public ArrayList<KhoHangDTO> search(String searchContent){
        ArrayList<KhoHangDTO> arr = new ArrayList<>();
        return arr;
    }
    
    public ArrayList<String> getWarehouseID(){
        ArrayList<String> arrMaKho = new ArrayList<>();
        if(openConnection()){
            try{
                String query = "SELECT * FROM khohang WHERE trangthai = 1";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String warehouseID = new String();
                    warehouseID = rs.getString(1);
                    
                    arrMaKho.add(warehouseID);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return arrMaKho;
    }
}
