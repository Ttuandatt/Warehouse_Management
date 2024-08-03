/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

public class TaiKhoanBUS {
    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    
    public ArrayList<TaiKhoanDTO> getAllTaiKhoan(){
        return taiKhoanDAO.getAll();
    } 
    
    public String addTaiKhoan(TaiKhoanDTO tk){
        if(taiKhoanDAO.has(tk.getMaNv()))
            return "Nhân viên đã có tài khoản";
        if(taiKhoanDAO.add(tk))
            return "Thêm tài khoản thành công";
        return "Thêm tài khoản thất bại";
    }
    
    public String deleteTaiKhoan(String manv){
        if(taiKhoanDAO.delete(manv))
            return "Xóa tài khoản thành công";
        return "Xóa tài khoản thất bại";
    }
    
    public String updateTaiKhoan(TaiKhoanDTO tk){
        if(taiKhoanDAO.update(tk))
            return "Cập nhật tài khoản thành công";
        return "Cập nhật tài khoản thất bại";
    }
}
