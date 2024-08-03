/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class NhaCungCapDTO {
    private String maNCC;
    private String tenNCC;
    private String diaChiNCC;
    private String sdt;
    private int trangthai;
    
    
    //Constructor
    public NhaCungCapDTO(){
        
    }
    public NhaCungCapDTO(String maNCC, String tenNCC, String diaChiNCC, String sdt){
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChiNCC = diaChiNCC;
        this.sdt = sdt;
    }
    
    public NhaCungCapDTO(String maNCC, String tenNCC, String diaChiNCC, String sdt, int trangthai){
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChiNCC = diaChiNCC;
        this.sdt = sdt;
        this.trangthai = trangthai;
    }
    
    public String getMaNCC(){
        return this.maNCC;
    }
    public void setMaNCC(String maNCC){
        this.maNCC = maNCC;
    }
    
    public String getTenNCC(){
        return this.tenNCC;
    }
    public void setTenNCC(String tenNCC){
        this.tenNCC = tenNCC;
    }
    
    public String getDiaChiNCC(){
        return this.diaChiNCC;
    }
    public void setDiaChiNCC(String diaChiNCC){
        this.diaChiNCC = diaChiNCC;
    }
    
    public String getSdt(){
        return this.sdt;
    }
    public void setSdt(String sdt){
        this.sdt = sdt; 
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
}
