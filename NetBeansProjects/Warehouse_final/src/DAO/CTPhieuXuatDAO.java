/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.Constant;
import DTO.CTPhieuXuatDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author ACER
 */
public class CTPhieuXuatDAO {
	private String dbUrl = Constant.dbUrl;
        private String username = Constant.username;
        private String password = Constant.password;
    Connection con;
    
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
    
    public ArrayList<CTPhieuXuatDTO> getAllByID(String mapx){
        ArrayList<CTPhieuXuatDTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String query = "SELECT * FROM ctphieuxuat WHERE mapx = ? AND trangthai = 1";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, mapx);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    CTPhieuXuatDTO ctpxDTO = new CTPhieuXuatDTO();
                    ctpxDTO.setMapx(rs.getString(1));
                    ctpxDTO.setMaSP(rs.getString(2));
                    ctpxDTO.setTenSP(rs.getString(3));
                    ctpxDTO.setSoLuongSP(rs.getInt(4));
                    ctpxDTO.setGiaSP(rs.getInt(5));
                    
                    arr.add(ctpxDTO);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public boolean add(CTPhieuXuatDTO ctpx){
        boolean result = false;
        if(openConnection()){
            try{
                String queryInsert = "INSERT INTO ctphieuxuat VALUES (?,?,?,?,?,?)";    // Thêm sản phẩm vào bảng ctphieuxuat
                PreparedStatement psInsert = con.prepareStatement(queryInsert);
                psInsert.setString(1, ctpx.getMapx());
                psInsert.setString(2, ctpx.getMaSP());
                psInsert.setString(3, ctpx.getTenSP());
                psInsert.setInt(4, ctpx.getSoLuongSP());
                psInsert.setInt(5, ctpx.getGiaSP());
                psInsert.setInt(6, 1);
                int rowsInserted = psInsert.executeUpdate();
                
                if(rowsInserted>0){
                    String queryUpdate = "UPDATE sanpham SET soluong = soluong - ? WHERE masp = ?"; // Trừ số lượng sản phẩm đó ở bảng sản phẩm
                    PreparedStatement psUpdate = con.prepareStatement(queryUpdate);
                    psUpdate.setInt(1, ctpx.getSoLuongSP());
                    psUpdate.setString(2, ctpx.getMaSP());
                    int rowsUpdate = psUpdate.executeUpdate();
                    
                    if(rowsUpdate>0)
                        result = true;
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean delete(String mapx){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "UPDATE ctphieuxuat SET trangthai = 0 WHERE mapx = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, mapx);
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
    
//    public ArrayList<CTPhieuXuatDTO> getAll(){
//        ArrayList<CTPhieuXuatDTO> arr = new ArrayList<>();
//        if(openConnetion()){
//            try{
//                String query = "SELECT * FROM ctphieuxuat";
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
//    }
}
