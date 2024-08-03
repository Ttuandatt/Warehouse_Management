package BUS;
import DAO.*;
import DTO.*;
import java.util.ArrayList;
public class CTPhieuNhapBUS {
	CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();
	public void add(CTPhieuNhapDTO ctpn) {
		ctpnDAO.add(ctpn);
	}
	public ArrayList<CTPhieuNhapDTO> getAllByID(String mapn){
		return ctpnDAO.getAllByID(mapn);
	}
	public ArrayList<CTPhieuNhapDTO> getByGia(String data,String condition,String ma){
		return ctpnDAO.getByGia(data, condition,ma);
	}
	public ArrayList<CTPhieuNhapDTO> getByCondition(String data,String condition,String ma){
		return ctpnDAO.getByCondition(data, condition,ma);
	}
	public ArrayList<CTPhieuNhapDTO> getBySoLuong(String data,String condition,String ma){
		return ctpnDAO.getBySoluong(data, condition,ma);
	}
	public void updateTrangThai(String ma) {
		ctpnDAO.updateTrangthai(ma);
	}
}