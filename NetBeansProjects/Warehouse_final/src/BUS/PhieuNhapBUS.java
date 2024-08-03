package BUS;

import java.util.ArrayList;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;

public class PhieuNhapBUS {
	PhieuNhapDAO pnDAO=new PhieuNhapDAO();
        
	public ArrayList<PhieuNhapDTO> getAllPhieuNhap(){
		return pnDAO.getAll();
	}
	public int getSoLuongPhieu() {
		return pnDAO.countPhieuNhap();
	}
	public void add(PhieuNhapDTO phieunhap) {
		pnDAO.add(phieunhap);
	}
        public String delete(String mapn) {
		return pnDAO.delete(mapn)?"Xóa thành công":"Đã xảy ra lỗi";
	}
        public int countPhieuNhap(){
            return pnDAO.countPhieuNhap();
        }
        public ArrayList<PhieuNhapDTO> getByTongTien(String data,String condition){
		return pnDAO.getByTongTien(data, condition);
	}
	public ArrayList<PhieuNhapDTO> getByCondition(String data,String condition){
		return pnDAO.getByID(data, condition);
	}
	public ArrayList<PhieuNhapDTO> getByDate(String data,String condition){
		return pnDAO.getByDate(data, condition);
	}
	public ArrayList<PhieuNhapDTO> getStartEndDate(String start,String end){
		return pnDAO.getByStartEnd(start,end);
	}
	public ArrayList<String> getAllMakho(){
		return pnDAO.getAllMaKho();
	}  
}