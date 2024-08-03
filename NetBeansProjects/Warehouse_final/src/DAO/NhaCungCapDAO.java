/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.Constant;
import DTO.NhaCungCapDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author ACER
 */
public class NhaCungCapDAO implements DAOInterface<NhaCungCapDTO>{
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
    public ArrayList<NhaCungCapDTO> getAll(){
        ArrayList<NhaCungCapDTO> arr = new ArrayList<NhaCungCapDTO>();
        if(openConnection()){
            try{
                String query = "SELECT * FROM nhacungcap WHERE trangthai = 1";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    NhaCungCapDTO nhacungcapDTO = new NhaCungCapDTO();
                    nhacungcapDTO.setMaNCC(rs.getString(1));
                    nhacungcapDTO.setTenNCC(rs.getString(2));
                    nhacungcapDTO.setDiaChiNCC(rs.getString(3));
                    nhacungcapDTO.setSdt(rs.getString(4));
                    
                    arr.add(nhacungcapDTO);
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
    public boolean has(String mancc){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "SELECT * FROM nhacungcap WHERE mancc = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, mancc);
                ResultSet rs =  ps.executeQuery();
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
    public boolean add(NhaCungCapDTO ncc){
        boolean result = false;
        if(openConnection()){
            try{
                String query = "INSERT INTO nhacungcap VALUES (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, ncc.getMaNCC());
                ps.setString(2, ncc.getTenNCC());
                ps.setString(3, ncc.getDiaChiNCC());
                ps.setString(4, ncc.getSdt());
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
    public boolean delete(String mancc) {
        boolean result = false;
        if(openConnection()){
            try {
                String query = "UPDATE nhacungcap SET trangthai = 0 WHERE maNCC = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, mancc);
                if(ps.executeUpdate()>0)
                    result = true;
            }catch (Exception e) {
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        } 
        return result;
    }
    
    
    @Override
    public boolean update(NhaCungCapDTO ncc) {
        boolean result = false;
        if(openConnection()){
            try {
                Connection con = DriverManager.getConnection(dbUrl, username, password);
                String query = "UPDATE nhacungcap SET tenncc = ?, diachi = ?, sdt = ? WHERE mancc = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, ncc.getTenNCC());
                ps.setString(2, ncc.getDiaChiNCC());
                ps.setString(3, ncc.getSdt());
                ps.setString(4, ncc.getMaNCC());
        
                if (ps.executeUpdate() > 0)
                    return true;
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    @Override
    public NhaCungCapDTO getByID(String maNCC){
        NhaCungCapDTO ncc = null;
        if(openConnection()){
            try{
                Connection con = DriverManager.getConnection(dbUrl, username, password);
                String query = "SELECT * FROM nhacungcap WHERE mancc = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, maNCC);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    String mancc = rs.getString(1);
                    String tenncc = rs.getString(2);
                    String diachi = rs.getString(3);
                    String sdt = rs.getString(4);
                
                    ncc = new NhaCungCapDTO(mancc, tenncc, diachi, sdt);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return ncc;
    }
    
    @Override
    public ArrayList<NhaCungCapDTO> search(String searchContent){
        ArrayList<NhaCungCapDTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String query = "SELECT * FROM sanpham WHERE "
                        + "mancc LIKE ? OR "
                        + "tenncc LIKE ? OR"
                        + "diachi LIKE ? OR"
                        + "sdt LIKE ? OR";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, "%" + searchContent + "%");
                ps.setString(2, "%" + searchContent + "%");
                ps.setString(3, "%" + searchContent + "%");
                ps.setString(4, "%" + searchContent + "%");
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    NhaCungCapDTO ncc = new NhaCungCapDTO();
                    ncc.setMaNCC(rs.getString(1));
                    ncc.setTenNCC(rs.getString(2));
                    ncc.setDiaChiNCC(rs.getString(3));
                    ncc.setSdt(rs.getString(4));
                    
                    
                    arr.add(ncc);

                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public NhaCungCapDTO getByName(String tenncc) {
		NhaCungCapDTO ncc = null;
		if (openConnection()) {
			try {
				String query = "select mancc,tenncc,diachi,sdt from nhacungcap where tenncc like ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, "%" + tenncc + "%");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String mancc = rs.getString(1);
					String tencc=rs.getString(2);
					String diachi=rs.getString(3);
					String sdt=rs.getString(4);
					ncc=new NhaCungCapDTO(mancc,tencc,diachi,sdt);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return ncc;

	}
}
