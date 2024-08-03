/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class TaiKhoanDTO {
    private String manv;
    private String matkhau;
    private int loai;
    
    
    public TaiKhoanDTO(){
        
    }
    
    public TaiKhoanDTO( String manv, String matkhau, int loai){
        this.manv = manv;
        this.matkhau = matkhau;
        this.loai = loai;
        
    }
    
    
    
    public String getMatKhau(){
        return this.matkhau;
    }
    
    public void setMatKhau(String matkhau){
        this.matkhau = matkhau;
    }
    
    public int getLoai(){
        return this.loai;
    }
    
    public void setLoai(int loai){
        this.loai = loai;
    }
    
    public String getMaNv(){
        return this.manv;
    }
    
    public void setMaNV(String manv){
        this.manv = manv;
    }
}

