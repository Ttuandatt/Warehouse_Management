/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuXuatDAO;
import DTO.PhieuXuatDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class PhieuXuatBUS {
    PhieuXuatDAO pxDAO = new PhieuXuatDAO();
    
    public ArrayList<PhieuXuatDTO> getAllPhieuXuat(){
        return pxDAO.getAll();  
    }
    public String addPhieuXuat(PhieuXuatDTO px){
        if(pxDAO.has(String.valueOf(px.getMapx())))
            return "Mã phiếu xuất đã tồn tại";
        if(pxDAO.add(px))
            return "Thêm px thành công";
        return "Thêm px thất bại";
    }
    
    public String deletePhieuXuat(int mapx){
        if(pxDAO.delete(String.valueOf(mapx)))
            return "Xoá phiếu xuất thành công";
        return "Xoá phiếu xuất thất bại1";
    }
    
    public String updatePhieuXuat(PhieuXuatDTO px){
        if(pxDAO.update(px))
            return "Cập nhật thành công";
        return "Cập nhật thất bại";
    }
    
    public int countPhieuXuat(){
        return pxDAO.countPhieuXuat();
    }  
    
    public ArrayList<String> getAllMakho(){
    	return pxDAO.getAllMaKho();
    }
    public ArrayList<PhieuXuatDTO> getByMakho(String makho){
    	return pxDAO.getByMaKho(makho);
    }	
    public ArrayList<PhieuXuatDTO> getByDate(String data,String condition){
		return pxDAO.getByDate(data, condition);
	}
    public ArrayList<PhieuXuatDTO> getStartEndDate(String start,String end){
	return pxDAO.getByStartEnd(start,end);
    }
}
