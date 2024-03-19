// SanPhamDAO.java
package Model;

import Lop.SanPham;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private String dbUrl = "jdbc:mysql://localhost:3306/quanlykhohang";
    private String username = "root";
    private String password = "123456";

    public List<SanPham> getAllSanPham() {
        List<SanPham> sanPhams = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, password);
            String query = "SELECT * FROM sanpham";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maMay = rs.getString(1);
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
}
