package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.CTPhieuNhapDTO;
import Config.Constant;

public class CTPhieuNhapDAO implements DAOInterface<CTPhieuNhapDTO> {
	private String dbUrl = Constant.dbUrl;
        private String username = Constant.username;
        private String password = Constant.password;
        private Connection con;

	public boolean openConnection() {
		try {
			con = DriverManager.getConnection(dbUrl, username, password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void closeConnection() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<CTPhieuNhapDTO> getAll() {
            
            return null;
	}

	public ArrayList<CTPhieuNhapDTO> getAllByID(String mapn) {
		ArrayList<CTPhieuNhapDTO> arr = new ArrayList<>();
		if (openConnection()) {
			try {
				String query = "select * from ctphieunhap where mapn=? and trangthai = 1";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, mapn);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String maphieu = rs.getString(1);
					String masp = rs.getString(2);
					String tensp = rs.getString(3);
					int soluong = rs.getInt(4);
					int gia = rs.getInt(5);
					arr.add(new CTPhieuNhapDTO(maphieu, masp, tensp, soluong, gia));
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
	public boolean has(String d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(CTPhieuNhapDTO ctphieu) {
		boolean result=false;
		if(openConnection()) {
			try {
				String query="Insert into ctphieunhap values(?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, ctphieu.getMapn());
				ps.setString(2,ctphieu.getMasp());
				ps.setString(3,ctphieu.getTensp() );
				ps.setInt(4, ctphieu.getSoluong());
				ps.setInt(5, ctphieu.getGia());
                                ps.setInt(6, 1);
                if(ps.executeUpdate()>0)
                    result = true;
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				closeConnection();
			}
		}
		// TODO Auto-generated method stub
		return result;
	}
        
        public boolean updateTrangthai(String ma) {
		if(openConnection()) {
			try {
				String query="update ctphieunhap set trangthai=0 where mapn = ?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, ma);
				if (ps.executeUpdate() > 0)
					return true;
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				closeConnection();
			}
		}
		// TODO Auto-generated method stub
		return false;
	}
        
        public ArrayList<CTPhieuNhapDTO> getByCondition(String data, String condition,String ma) {
		ArrayList<CTPhieuNhapDTO> arr = new ArrayList<CTPhieuNhapDTO>();
		if (openConnection()) {
			try {
				String query = "select mapn,masp,tensp,soluong,gia from ctphieunhap where "
						+ condition + " like ? and mapn = ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, "%" + data + "%");
				ps.setString(2, ma);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String mapn = rs.getString(1);
					String masp = rs.getString(2);
					String tensp = rs.getString(3);
					int soluong = rs.getInt(4);
					int tongtien = rs.getInt(5);
					arr.add(new CTPhieuNhapDTO(mapn,masp,tensp,soluong,tongtien));
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
	public ArrayList<CTPhieuNhapDTO> getBySoluong(String data, String condition,String ma) {
		ArrayList<CTPhieuNhapDTO> arr = new ArrayList<CTPhieuNhapDTO>();
		if (openConnection()) {
			try {
				String query = "select mapn,masp,tensp,soluong,gia from ctphieunhap where soluong "
						+ condition + " ? and mapn = ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,  data);
				ps.setString(2, ma);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String mapn = rs.getString(1);
					String masp = rs.getString(2);
					String tensp = rs.getString(3);
					int soluong = rs.getInt(4);
					int tongtien = rs.getInt(5);
					arr.add(new CTPhieuNhapDTO(mapn,masp,tensp,soluong,tongtien));
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
	public ArrayList<CTPhieuNhapDTO> getByGia(String data, String condition,String ma) {
		ArrayList<CTPhieuNhapDTO> arr = new ArrayList<CTPhieuNhapDTO>();
		if (openConnection()) {
			try {
				String query = "select mapn,masp,tensp,soluong,gia from ctphieunhap where gia "
						+ condition + " ? and mapn= ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,  data);
				ps.setString(2, ma);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String mapn = rs.getString(1);
					String masp = rs.getString(2);
					String tensp = rs.getString(3);
					int soluong = rs.getInt(4);
					int tongtien = rs.getInt(5);
					arr.add(new CTPhieuNhapDTO(mapn,masp,tensp,soluong,tongtien));
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
        
	@Override
	public boolean delete(String d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CTPhieuNhapDTO d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CTPhieuNhapDTO getByID(String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CTPhieuNhapDTO> search(String d) {
		// TODO Auto-generated method stub
		return null;
	}
}