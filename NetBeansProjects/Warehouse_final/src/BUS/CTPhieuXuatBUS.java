/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.CTPhieuXuatDAO;
import DTO.CTPhieuXuatDTO;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class CTPhieuXuatBUS {
    CTPhieuXuatDAO ctpxDAO = new CTPhieuXuatDAO();
    
    public ArrayList<CTPhieuXuatDTO> getAllCTPhieuXuat(String mapx){
        return ctpxDAO.getAllByID(mapx);
    }
    
    public String addCTPhieuXuat(CTPhieuXuatDTO ctpx){
        if(ctpxDAO.add(ctpx))
            return "Thêm chi tiết phiếu xuất thành công";
        return "Thêm chi tiết phiếu xuất thất bại";
    }
    
    public String deleteCTPhieuXuat(String matcpx){
        if(ctpxDAO.delete(matcpx))
            return "Xóa chi tiết phiếu xuất thành công";
        return "Xóa chi tiết phiếu xuất thất bại";
    }
    
    public String updateCTPhieuXuat(CTPhieuXuatDTO ctpx){
        return "Đây là phương thức updateCTPhieuXuat ở CTPhieuXuatBUS";
    }
}
