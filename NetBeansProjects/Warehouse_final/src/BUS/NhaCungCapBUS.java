/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {
    NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    
    public ArrayList<NhaCungCapDTO> getAllNhaCungCap(){
        return nccDAO.getAll();
    }
    
    public String addNhaCungCap(NhaCungCapDTO ncc){
        if(nccDAO.has(ncc.getMaNCC()))
            return "Mã nhà cung cấp đã tồn tại";
        if(nccDAO.add(ncc))
            return "Thêm nhà cung cấp thành công";
        return "Thêm thất bại";
    }
    
    public String deleteNhaCungCap(String mancc){
        if(nccDAO.delete(mancc))
            return "Xóa nhà cung cấp thành công";
        return "Xóa nhà cung cấp thất bại";
    }
    
    public String updateNhaCungCap(NhaCungCapDTO ncc){
        if(nccDAO.update(ncc))
            return "Cập nhật nhà cung cấp thành công";
        return "Cập nhật nhà cung cấp thất bại";
    }
    
    public NhaCungCapDTO getByName(String tenncc) {
    	return nccDAO.getByName(tenncc);
    }
   
}
