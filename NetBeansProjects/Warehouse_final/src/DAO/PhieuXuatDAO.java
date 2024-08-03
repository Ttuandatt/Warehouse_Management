/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.Constant;
import DTO.PhieuXuatDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;


public class PhieuXuatDAO implements DAOInterface<PhieuXuatDTO>{
	private final String dbUrl = "jdbc:mysql://localhost:3306/quanlykhohang";
    private final String username = "root";
    private final String password = "123456";
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
            if(con!=null)   //con đang kết nối tới database sẽ != null
                con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<PhieuXuatDTO> getAll() {
        ArrayList<PhieuXuatDTO> arr = new ArrayList<>();

        if (openConnection()) {
            try {
                String query = "SELECT * FROM phieuxuat WHERE trangthai = 1";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    PhieuXuatDTO pxDTO = new PhieuXuatDTO();
                    pxDTO.setMapx(rs.getString(1)); 
                    pxDTO.setManguoitao(rs.getString(2)); 
                    pxDTO.setMakho(rs.getString(3));
                    pxDTO.setMakhachhang(rs.getString(4));
                    LocalDate dateFromDatabase = rs.getObject("thoigiantao", LocalDate.class);
                    pxDTO.setThoigiantao(dateFromDatabase); 
                    pxDTO.setTongtien(rs.getInt(6)); 
                    
                    arr.add(pxDTO);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }
        return arr;
    }
    @Override
    public boolean has(String mapx){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "SELECT *FROM phieuxuat where mapx = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,mapx);
                ResultSet rs = ps.executeQuery();   // Trả về 1 đối tượng dạng bảng
                result = rs.next(); // rs.next(): di chuyển con trỏ đến dòng tiếp theo, trả về true nếu di chuyển đến dòng tiếp theo thành công (tức là có từ 1 dòng trở lên), false thì ngược lại
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
    
        }
    
        return result;
    }
    
    @Override
    public boolean add(PhieuXuatDTO px){
        boolean result = false;
        if(openConnection()) {
            try{
                String query = "INSERT INTO phieuxuat VALUES (?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, px.getMapx());
                ps.setString(2, px.getManguoitao());
                ps.setString(3, px.getMakho());
                ps.setString(4, px.getMakhachhang());
                ps.setString(5, String.valueOf(px.getThoigiantao()));
//                System.out.println(px.getThoigiantao());
                ps.setInt(6, px.getTongtien());
                ps.setInt(7, 1);
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
    public boolean delete(String mapx) {
        boolean result = false;
        if (openConnection()) {
            try {
                String query = "UPDATE phieuxuat SET trangthai = 0 WHERE mapx = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, mapx);
                if (ps.executeUpdate() > 0) {
                    result = true;
                }
            } catch (Exception e) {
                e.printStackTrace(); // Handle or log the exception
            } finally {
                closeConnection(); // Close database connection
            }
        }   
        return result;
    }

    @Override
    public boolean update(PhieuXuatDTO px){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "UPDATE phieuxuat SET manguoitao = ?, makho = ?, makhachhang = ? WHERE mapx = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, px.getManguoitao());
                ps.setString(2, px.getMakho());
                ps.setString(3, px.getMakhachhang());
                ps.setString(4,px.getMapx());
                if(ps.executeUpdate()>0)
                    return true;
            }catch (Exception e) {
                e.printStackTrace();
            } finally{
                closeConnection();
            }
        }

        return result;

    }

    @Override
    public PhieuXuatDTO getByID(String mapx){
        PhieuXuatDTO phieuXuat = null;
        if(openConnection()){
            try{
                String query = "SELECT * FROM phieuxuat WHERE mapx = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,mapx);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    String nguoitao = rs.getString(2);
                    int tongtien = rs.getInt(3);
                }

            }catch (Exception e) {
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return phieuXuat;

    }
    
    
    @Override
    public ArrayList<PhieuXuatDTO> search(String searchContent){
        ArrayList<PhieuXuatDTO> arr = new ArrayList<>();
        return arr;
    }

    
    public int countPhieuXuat(){
        int count = 0;
        if(openConnection()){
           try{
              String query = "SELECT COUNT(*) FROM phieuxuat";
              PreparedStatement ps = con.prepareStatement(query);
              ResultSet rs = ps.executeQuery();
              if(rs.next()){
                  count = rs.getInt(1); // Lấy số lượng bản ghi từ cột đầu tiên của kết quả truy vấn
              }
           }catch(Exception e){
               e.printStackTrace();
           } finally{
               closeConnection();
           }
        }
        return count;
    }

    public ArrayList<String> getAllMaKho(){
		ArrayList<String> arr =new ArrayList<String>();
		if(openConnection()) {
			try {
				String query="select distinct makho from phieuxuat where trangthai=1";
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {

					arr.add(rs.getString(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				closeConnection();
			}
		}
		return arr;
	}
	public ArrayList<PhieuXuatDTO> getByMaKho(String makho){
		ArrayList<PhieuXuatDTO> arr=new ArrayList<PhieuXuatDTO>();
		if(openConnection()) {
			try {
				 String query = "SELECT * FROM phieuxuat WHERE makho like ? and trangthai = 1";
	                PreparedStatement ps = con.prepareStatement(query);
	                ps.setString(1,"%"+ makho+"%");
	                ResultSet rs = ps.executeQuery();
	                
	                while (rs.next()) {
	                    PhieuXuatDTO pxDTO = new PhieuXuatDTO();
	                    pxDTO.setMapx(rs.getString(1)); 
	                    pxDTO.setManguoitao(rs.getString(2)); 
	                    pxDTO.setMakho(rs.getString(3));
	                    pxDTO.setMakhachhang(rs.getString(4));
	                    LocalDate dateFromDatabase = rs.getObject("thoigiantao", LocalDate.class);
	                    pxDTO.setThoigiantao(dateFromDatabase); 
	                    pxDTO.setTongtien(rs.getInt(6)); 
	                    
	                    arr.add(pxDTO);
	                }
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				closeConnection();
			}
		}
		return arr;
	}

	public ArrayList<PhieuXuatDTO> getByDate(String data, String condition) {
		ArrayList<PhieuXuatDTO> arr = new ArrayList<PhieuXuatDTO>();

		if (openConnection()) {
			try {
				String query = "select mapx,manguoitao,makho,makhachhang,thoigiantao,tongtien,trangthai from phieuxuat where  thoigiantao "
						+ condition + " ? and trangthai=1";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,  data );
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String mapx = rs.getString(1);
					String manguoitao = rs.getString(2);
					String makho = rs.getString(3);
					String makh = rs.getString(4);
					Date sqlDate = rs.getDate(5);
					LocalDate thoigiantao = sqlDate.toLocalDate();
					int tongtien = rs.getInt(6);
					arr.add(new PhieuXuatDTO(mapx, manguoitao, makho,makh ,thoigiantao, tongtien, 1));

				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		// TODO Auto-generated method stub
		return arr;
	}

	public ArrayList<PhieuXuatDTO> getByStartEnd(String start,String end) {
		ArrayList<PhieuXuatDTO> arr = new ArrayList<PhieuXuatDTO>();

		if (openConnection()) {
			try {
				String query = "select mapx,manguoitao,makho,makhachhang,thoigiantao,tongtien,trangthai from phieuxuat where  thoigiantao between ?  and ?  and trangthai=1";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,  start  );
				ps.setString(2, end );
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String mapx = rs.getString(1);
					String manguoitao = rs.getString(2);
					String makho = rs.getString(3);
					String makh = rs.getString(4);
					Date sqlDate = rs.getDate(5);
					LocalDate thoigiantao = sqlDate.toLocalDate();
					int tongtien = rs.getInt(6);
					arr.add(new PhieuXuatDTO(mapx, manguoitao, makho,makh ,thoigiantao, tongtien, 1));

				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		// TODO Auto-generated method stub
		return arr;
	}
}
