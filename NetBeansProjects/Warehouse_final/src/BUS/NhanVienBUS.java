/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.*;

public class NhanVienBUS {
    NhanVienDAO nvDAO = new NhanVienDAO();
    
    public ArrayList<NhanVienDTO> getAllNhanVien(){
        return nvDAO.getAll();
    }
    
    public String addNhanVien(NhanVienDTO nv){
        if(nvDAO.has(nv.getManv()))
            return "Nhân viên đã tồn tại";
        if(nvDAO.add(nv))
            return "Thêm nhân viên thành công";
        return "Thêm nhân viên thất bại";
    }
    
    public String deleteNhanVien(String manv){
        if(nvDAO.delete(manv))
            return "Xóa nhân viên thành công";
        return "Xóa nhân viên thất bại";
    }
    
    public String updateNhanVien(NhanVienDTO nv){
        if(nvDAO.update(nv))
            return "Cập nhật nhân viên thành công";
        return "Cập nhật nhân viên thất bại";
    }
    public String getMaKho(String manv) {
    	return nvDAO.getMaKho(manv);
    	
    }
}