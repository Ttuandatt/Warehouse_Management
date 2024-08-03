/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.KhoHangDTO;
import DAO.KhoHangDAO;
import java.util.ArrayList;

public class KhoHangBUS {
    KhoHangDAO khoDAO = new KhoHangDAO();
    
    public ArrayList<KhoHangDTO> getAllKhoHang(){
        return khoDAO.getAll();
    }
    
    public ArrayList<String> getAllMaKho(){
        return khoDAO.getWarehouseID();
    }
    
    public String addKhoHang(KhoHangDTO kho){
        if(khoDAO.has(kho.getMaKho()))
            return "Mã kho đã tồn tại";
        if(khoDAO.add(kho))
            return "Thêm kho hàng thành công";
        return "Thêm kho hàng thất bại";
    }
    
    public String deleteKhoHang(String makho){
        if(khoDAO.delete(makho))
            return "Xóa kho thành công";
        return "Xóa kho thất bại";
    }
    
    public String updateKhoHang(KhoHangDTO kho){
        if(khoDAO.update(kho))
            return "Cập nhật kho thành công";
        return "Cập nhật kho thất bại";
    }
}
