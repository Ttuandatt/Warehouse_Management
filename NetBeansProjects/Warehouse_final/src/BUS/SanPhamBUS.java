/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

public class SanPhamBUS {
    SanPhamDAO spDAO = new SanPhamDAO();
    
    public ArrayList<SanPhamDTO> getAllSanPham(){
        return spDAO.getAll();
    }
    public String addSanPham(SanPhamDTO sp){
        if(spDAO.has(sp.getMaMay()))
            return "Mã sản phẩm đã tồn tại";
        if(spDAO.add(sp))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String deleteSanPham(String masp){   //Dung String vì một lát ở bên SanPhamGUI sẽ lấy mã từ selectedRow chứ không lấy được nguyên 1 object SanPhamDTO
        if(spDAO.delete(masp))
            return "Xóa sản phẩm thành công";
        return "Xóa sản phẩm thất bại";
    }
    
    public String updateSanPham(SanPhamDTO sp){
        if(spDAO.update(sp))
            return "Cập nhật sản phẩm thành công";
        return "Cập nhật sản phẩm thất bại";
    }
    
    public String tangSoLuong(String masp, int soLuong){
        if(spDAO.tangSoLuong(masp, soLuong))
            return "Tăng số lượng thành công";
        return "Tăng số lượng thất bại";
    }
    
    public String nhapHang(SanPhamDTO sp){
        if(spDAO.importProduct(sp))
            return "Nhập hàng thành công";
        return "Nhập hàng thất bại";
    }
    
    public SanPhamDTO getSanPhamByMaSP(String masp) {
    	return new SanPhamDAO().getByID(masp);
    }
    
    public ArrayList<SanPhamDTO> getSanPhamByCondition(String condition,String dataCondition){
    	return spDAO.searchSanPhamByCondition(condition, dataCondition);
    }
    public ArrayList<SanPhamDTO> getSanPhamByGia(int gia,String condition){
    	return spDAO.searchSanPhamByGia(gia,condition);
    }
    
    public ArrayList<SanPhamDTO> getProductsByWarehouse(String maKho) {
        ArrayList<SanPhamDTO> productsByWarehouse = new ArrayList<>();
        ArrayList<SanPhamDTO> allProducts = getAllSanPham(); 
        for (SanPhamDTO product : allProducts) {
            if (product.getMaKho().equals(maKho)) {
                productsByWarehouse.add(product);
            }
        }
    
        return productsByWarehouse;
    }
}
