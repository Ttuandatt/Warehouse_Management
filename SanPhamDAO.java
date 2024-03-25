// SanPhamDAO.java
package Model;

import Lop.SanPham;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SanPhamDAO {
    private String dbUrl = "jdbc:mysql://localhost:3306/quanlykhohang";
    private String username = "root";
    private String password = "123456";

    public List<SanPham> getAllSanPham() {
        List<SanPham> sanPhams = new ArrayList<>(); //Mặc dù khai báo là List, nhưng sanPhams thực chất là 1 đối tượng của lớp ArrayList, vì ArrayList là một lớp triển khai của List
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, password);
            String query = "SELECT * FROM sanpham";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maMay = rs.getString(1); //1,2,3,4,5,6,7,8 là các cột trong bảng
                String tenMay = rs.getString(2);
                int soLuong = rs.getInt(3);
                int gia = rs.getInt(4);
                String boXuLy = rs.getString(5);
                String boNho = rs.getString(6);
                int ram = rs.getInt(7);
                String nhaCungCap = rs.getString(8);
                SanPham sanPham = new SanPham(maMay, tenMay, soLuong, gia, boXuLy, boNho, ram, nhaCungCap);
                sanPhams.add(sanPham);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPhams;
    }
    
    public void addSanPham(String maSP, String tenSP, int soLuong, int gia, String boXuLy, String boNho, int ram, String nhaCC){
        try{
            Connection con = DriverManager.getConnection(dbUrl, username, password);
            String query = "INSERT INTO sanpham(masp, tensp, soluong, giaban, boxuly, bonho, ram, nhacungcap) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maSP);
            ps.setString(2, tenSP);
            ps.setInt(3, soLuong);
            ps.setInt(4, gia);
            ps.setString(5, boXuLy);
            ps.setString(6, boNho);
            ps.setInt(7, ram);
            ps.setString(8, nhaCC);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công");
            }
            con.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void deleteSanPham(SanPham sanPham) {
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, password);
            String query = "DELETE FROM sanpham WHERE masp = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sanPham.getMaMay());
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
