/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.Constant;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DTO.LoginDTO;
import DTO.TaiKhoanDTO;

public class LoginDAO{
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
    
//    public LoginDTO checkLogin(LoginDTO user){
//        if(openConnection()){
//            try{
//                String query = "SELECT * FROM taikhoan WHERE manv=? AND matkhau=?";
//                PreparedStatement  ps = con.prepareStatement(query);
//                ps.setString(1, user.getManv());
//                ps.setString(2, user.getPassword());
//                ResultSet rs = ps.executeQuery();
//
//                if(rs.next()){
//                    String taikhoan = rs.getString(1);
//                    String matkhau = rs.getString(2);
//                    int loai = rs.getInt(3);
//                    String manv = rs.getString(4);
//                    return new LoginDTO(manv, matkhau, loai);
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
//        return null;
//    }
    public int checkLogin(LoginDTO user) {
    int result = 0;
    if (openConnection()) {
        try {
            // Kiểm tra xem mã nhân viên có trong bảng 'nhanvien' không
            String queryCheckNV = "SELECT * FROM nhanvien WHERE manv = ?";
            PreparedStatement psCheckNV = con.prepareStatement(queryCheckNV);
            psCheckNV.setString(1, user.getManv());
            ResultSet rsCheckNV = psCheckNV.executeQuery();

            if (rsCheckNV.next()) {
                // Nhân viên có trong bảng 'nhanvien'
                
                // Kiểm tra xem mã nhân viên có trong bảng 'taikhoan' không
                String queryCheckTK = "SELECT * FROM taikhoan WHERE manv = ?";
                PreparedStatement psCheckTK = con.prepareStatement(queryCheckTK);
                psCheckTK.setString(1, user.getManv());
                ResultSet rsCheckTK = psCheckTK.executeQuery();

                if (rsCheckTK.next()) {
                    // Nhân viên có trong bảng 'taikhoan'
                    
                    // Lấy mật khẩu đã lưu trong bảng 'taikhoan'
                    String matkhauDB = rsCheckTK.getString("matkhau");
                    
                    if (matkhauDB.equals(user.getPassword())) {
                        // Mật khẩu khớp
                        result = 1;
                    } else {
                        // Mật khẩu không khớp
                        result = 4;
                    }
                } else {
                    // Nhân viên có trong bảng 'nhanvien' nhưng không có trong bảng 'taikhoan'
                    result = 2;
                }
            } else {
                // Nhân viên không có trong bảng 'nhanvien'
                result = 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    return result;
}
    
    public LoginDTO getAccountInformation(String manv, String password){
        LoginDTO userDTO = null;
        if(openConnection()){
            try{
                String query = "SELECT * FROM taikhoan WHERE manv=? AND matkhau=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, manv);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int loai  = rs.getInt(3);
                    userDTO = new LoginDTO(manv, password, loai);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                // Không đóng kết nối ở đây
                // closeConnection();
            }
        }
        return userDTO;
    }
}
