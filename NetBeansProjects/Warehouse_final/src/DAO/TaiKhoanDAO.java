/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.Constant;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaiKhoanDAO implements DAOInterface<TaiKhoanDTO>{
	private String dbUrl = Constant.dbUrl;
        private String username = Constant.username;
        private String password = Constant.password;
    private Connection con;
    
    
    public boolean openConnection(){
        boolean result = false;
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
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public ArrayList<TaiKhoanDTO> getAll(){
        ArrayList<TaiKhoanDTO> arr = new ArrayList<>();
        
        if(openConnection()){
            try{
                String query = "SELECT * FROM taikhoan WHERE trangthai = 1";
                PreparedStatement ps = con.prepareCall(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    TaiKhoanDTO taiKhoan = new TaiKhoanDTO();
                    taiKhoan.setMaNV(rs.getString(1));
                    taiKhoan.setMatKhau(rs.getString(2));
                    taiKhoan.setLoai(rs.getInt(3));
                    
                    arr.add(taiKhoan);
                }
            }catch(Exception e){
                
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    @Override
    public boolean has(String manv){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "SELECT * FROM taikhoan WHERE manv = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, manv);
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
    public boolean add(TaiKhoanDTO tk){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "INSERT INTO taikhoan VALUES (?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, tk.getMaNv());
                ps.setString(2, tk.getMatKhau());
                ps.setInt(3, tk.getLoai());
                ps.setInt(4, 1);
                if(ps.executeUpdate()>0)
                    result = true;
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    @Override
    public boolean delete(String manv){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "UPDATE taikhoan SET trangthai = 0 WHERE manv = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, manv);
                if(ps.executeUpdate()>0)
                    result =  true;
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    @Override
    public boolean update(TaiKhoanDTO tk){
        boolean result = false;
        if(openConnection()){
           try{
               String query = "UPDATE taikhoan SET matkhau = ?, loai = ?  WHERE manv = ?";
               PreparedStatement ps = con.prepareStatement(query);
               ps.setString(1, tk.getMatKhau());
               ps.setInt(2, tk.getLoai());
               ps.setString(3, tk.getMaNv());
               
               if(ps.executeUpdate()>0)
                   result = true;
           }catch(Exception e){
               e.printStackTrace();
           }finally{
               closeConnection();
           }
        }
        return result;
    }
    
    @Override
    public TaiKhoanDTO getByID(String manv){
        TaiKhoanDTO taiKhoan = null;
        if(openConnection()){
            try{
                String query = "SELECT * FROM taikhoan WHERE manv = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, manv);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    String maNV = rs.getString(1);
                    String password = rs.getString(2);
                    int type = rs.getInt(3);
                    
                    
                    taiKhoan = new TaiKhoanDTO(maNV, maNV, type);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return taiKhoan;
    }
    
    @Override
    public ArrayList<TaiKhoanDTO> search(String searchContent){
        ArrayList<TaiKhoanDTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String query = "SELECT * FROM taikhoan WHERE "
                        + "manv = ?"
                        + "matkhau = ? OR "
                        + "loai = ? OR ";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, "%" + searchContent + "%");
                ps.setString(2, "%" + searchContent + "%");
                ps.setString(3, "%" + searchContent + "%");
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    TaiKhoanDTO taiKhoan = new TaiKhoanDTO();
                    taiKhoan.setMatKhau(rs.getString(1));
                    taiKhoan.setLoai(rs.getInt(2));
                    taiKhoan.setMaNV(rs.getString(3));
                    
                    arr.add(taiKhoan);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
}
