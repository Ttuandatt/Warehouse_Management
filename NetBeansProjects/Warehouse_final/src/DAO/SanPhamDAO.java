// SanPhamDAO.java
package DAO;

import Config.Constant;
import DTO.SanPhamDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SanPhamDAO implements DAOInterface<SanPhamDTO>{
 	private String dbUrl = Constant.dbUrl;
        private String username = Constant.username;
        private String password = Constant.password;
    private Connection con;
    
    // Hàm thiết lập kết nối với database. Trả về true nếu succeed, false nếu fail.
    public boolean openConnection(){
        try{
            con = DriverManager.getConnection(dbUrl, username, password);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //Hàm đóng kết nối với database.
    public void closeConnection(){
        try{
            if(con!=null)   //con đang kết nối tới database sẽ != null
                con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public ArrayList<SanPhamDTO> getAll() {
        ArrayList<SanPhamDTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String query = "SELECT * FROM sanpham WHERE trangthai = 1";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();   // Trả về 1 đôi tượng dạng bảng
                while(rs.next()){   //Duyệt qua result set
                    SanPhamDTO sanPham = new SanPhamDTO(); //Tạo đối tượng
                    sanPham.setMaMay(rs.getString(1)); //Set thông tin cho đối tượng, thông tin được lấy từ rs
                    sanPham.setTenMay(rs.getString(2));
                    sanPham.setSoLuong(Integer.parseInt(rs.getString(3)));
                    sanPham.setGia(Integer.parseInt(rs.getString(4)));
                    sanPham.setBoXuLy(rs.getString(5));
                    sanPham.setBoNho(rs.getString(6));
                    sanPham.setRam(rs.getString(7));
                    sanPham.setGPU(rs.getString(8));
                    sanPham.setNhaCungCap(rs.getString(10));
                    sanPham.setMaKho(rs.getString(11));
                    
                    arr.add(sanPham);
                }
                rs.close();
                ps.close();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
            
        }
        return arr;
    }
    
    @Override
    public boolean has(String masp){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "SELECT * FROM sanpham WHERE masp = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,masp);
                ResultSet rs = ps.executeQuery();
                result = rs.next(); //Di chuyển con trỏ rs đến dòng tiếp theo, trả về true/false. Khi k có dòng tiếp theo để di chuyển tới thì trả về false, ngược lại thì true tức là có ít nhất 1 dòng dữ liệu
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    
    
    @Override
    public boolean add(SanPhamDTO sp){
        boolean result = false;
        if(openConnection()){
            try{
                // Nếu sản phẩm là mới hoàn toàn, thêm như bình thường
                String queryInsert = "INSERT INTO sanpham VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(queryInsert);
                ps.setString(1,sp.getMaMay());
                ps.setString(2,sp.getTenMay());
                ps.setInt(3, sp.getSoLuong());
                ps.setInt(4, sp.getGia());
                ps.setString(5,sp.getBoXuLy());
                ps.setString(6, sp.getBoNho());
                ps.setString(7,sp.getRam());
                ps.setString(8, sp.getGPU());
                ps.setString(9, sp.getKichthuocman());
                ps.setString(10, sp.getNhaCungCap());
                ps.setString(11,sp.getMaKho());
                ps.setInt(12, 1);
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
    public boolean delete(String masp) {
        boolean result = false;
        if(openConnection()){
            try{
                String query = "UPDATE sanpham SET trangthai = 0 WHERE masp = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, masp);
                if(ps.executeUpdate()>0){
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
    
    @Override
    public boolean update(SanPhamDTO sp) {
        boolean result = false;
        if(openConnection()){
            try {
                String query = "UPDATE sanpham SET tensp = ?, soluong = ?, giaban = ?, boxuly = ?, bonho = ?, ram = ?, gpu = ?, kichthuoc = ?, nhacungcap = ?, makho = ? WHERE masp = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, sp.getTenMay());
                ps.setInt(2, sp.getSoLuong());
                ps.setInt(3, sp.getGia());
                ps.setString(4, sp.getBoXuLy());
                ps.setString(5, sp.getBoNho());
                ps.setString(6, sp.getRam());
                ps.setString(7, sp.getGPU());
                ps.setString(8, sp.getKichthuocman());
                ps.setString(9, sp.getNhaCungCap());
                ps.setString(10,sp.getMaKho());
                ps.setString(11, sp.getMaMay());
        
                if (ps.executeUpdate() > 0)
                    return true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                closeConnection();
            }
        }
        return result;
    }

    @Override
    public SanPhamDTO getByID(String maSP) {
        SanPhamDTO sanPham = null;
        if(openConnection()){
            try {
                String query = "SELECT * FROM sanpham WHERE masp = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, maSP);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String maMay = rs.getString(1);
                    String tenMay = rs.getString(2);
                    int soLuong = rs.getInt(3);
                    int gia = rs.getInt(4);
                    String boXuLy = rs.getString(5);
                    String boNho = rs.getString(6);
                    String ram = rs.getString(7);
                    String gpu = rs.getString(8);
                    String kichThuocMan = rs.getString(9);
                    String nhaCungCap = rs.getString(10);
                    String kho = rs.getString(11);
                    sanPham = new SanPhamDTO(maMay, tenMay, soLuong, gia, boXuLy, boNho, ram, gpu, kichThuocMan, nhaCungCap, kho);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                closeConnection();
            }
        }
        return sanPham;
    }
    
    
    @Override
    public ArrayList<SanPhamDTO> search(String searchContent){
        ArrayList<SanPhamDTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String query = "SELECT * FROM sanpham WHERE "
                        + "masp LIKE ? OR "
                        + "tensp LIKE ? OR"
                        + "soluong LIKE ? OR"
                        + "giaban LIKE ? OR"
                        + "boxuly LIKE ? OR"
                        + "bonho LIKE ? OR"
                        + "ram LIKE ? OR"
                        + "gpu LIKE ? OR"
                        + "kichthuoc LIKE ? OR"
                        + "nhacungcap LIKE ? OR"
                        + "makho LIKE ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, "%" + searchContent + "%");
                ps.setString(2, "%" + searchContent + "%");
                ps.setString(3, "%" + searchContent + "%");
                ps.setString(4, "%" + searchContent + "%");
                ps.setString(5, "%" + searchContent + "%");
                ps.setString(6, "%" + searchContent + "%");
                ps.setString(7, "%" + searchContent + "%");
                ps.setString(8, "%" + searchContent + "%");
                ps.setString(9, "%" + searchContent + "%");
                ps.setString(10, "%" + searchContent + "%");
                ps.setString(11, "%" + searchContent + "%");
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    SanPhamDTO sanPham = new SanPhamDTO();
                    sanPham.setMaMay(rs.getString(1));
                    sanPham.setTenMay(rs.getString(2));
                    sanPham.setSoLuong(Integer.parseInt(rs.getString(3)));
                    sanPham.setGia(Integer.parseInt(rs.getString(4)));
                    sanPham.setBoXuLy(rs.getString(5));
                    sanPham.setBoNho(rs.getString(6));
                    sanPham.setRam(rs.getString(7));
                    sanPham.setGPU(rs.getString(8));
                    sanPham.setKichthuocman(rs.getString(9));
                    sanPham.setNhaCungCap(rs.getString(10));
                    sanPham.setMaKho(rs.getString(11));
                    
                    arr.add(sanPham);

                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public ArrayList<SanPhamDTO> searchSanPhamByCondition(String condition, String dataCondition) {
		ArrayList<SanPhamDTO> arr = new ArrayList<>();
		if (openConnection()) {
			try {
				String query = "select * from sanpham where "+ condition+" like ? ";
				
				PreparedStatement ps = con.prepareStatement(query);

				ps.setString(1,"%"+dataCondition+"%");
				ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						SanPhamDTO sanPham = new SanPhamDTO();
						sanPham.setMaMay(rs.getString(1));
						sanPham.setTenMay(rs.getString(2));
						sanPham.setSoLuong(Integer.parseInt(rs.getString(3)));
						sanPham.setGia(Integer.parseInt(rs.getString(4)));
						sanPham.setBoXuLy(rs.getString(5));
						sanPham.setBoNho(rs.getString(6));
						sanPham.setRam(rs.getString(7));
						sanPham.setGPU(rs.getString(8));
						sanPham.setKichthuocman(rs.getString(9));
						sanPham.setNhaCungCap(rs.getString(10));
						sanPham.setMaKho(rs.getString(11));

						arr.add(sanPham);

					}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}

		}

		return arr;
	}
	public ArrayList<SanPhamDTO> searchSanPhamByGia(int gia, String condition) {
		ArrayList<SanPhamDTO> arr = new ArrayList<>();
		if (openConnection()) {
			try {
				String query = "select * from sanpham where giaban"+condition+" ?";
				PreparedStatement ps = con.prepareStatement(query);

				ps.setInt(1, gia);
				ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						SanPhamDTO sanPham = new SanPhamDTO();
						sanPham.setMaMay(rs.getString(1));
						sanPham.setTenMay(rs.getString(2));
						sanPham.setSoLuong(Integer.parseInt(rs.getString(3)));
						sanPham.setGia(Integer.parseInt(rs.getString(4)));
						sanPham.setBoXuLy(rs.getString(5));
						sanPham.setBoNho(rs.getString(6));
						sanPham.setRam(rs.getString(7));
						sanPham.setGPU(rs.getString(8));
						sanPham.setKichthuocman(rs.getString(9));
						sanPham.setNhaCungCap(rs.getString(10));
						sanPham.setMaKho(rs.getString(11));

						arr.add(sanPham);

					}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}

		}
		return arr;
	}
    
    public boolean tangSoLuong(String masp, int soluong){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "UPDATE sanpham SET soluong = soluong + ? WHERE masp = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, soluong);
                ps.setString(2, masp);
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
    
    public boolean importProduct(SanPhamDTO sp){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "INSERT INTO sanpham VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,sp.getMaMay());
                ps.setString(2,sp.getTenMay());
                ps.setInt(3, sp.getSoLuong());
                ps.setInt(4, sp.getGia());
                ps.setString(5,sp.getBoXuLy());
                ps.setString(6, sp.getBoNho());
                ps.setString(7,sp.getRam());
                ps.setString(8, sp.getGPU());
                ps.setString(9, sp.getKichthuocman());
                ps.setString(10, sp.getNhaCungCap());
                ps.setString(11,sp.getMaKho());
                ps.setInt(12, 2);
                
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

}
