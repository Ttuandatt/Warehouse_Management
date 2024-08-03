/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class NhanVienDTO {
    private String manv;
    private String tennv;
    private String ngaysinh;
    private String gioitinh;
    private String diachi;
    private String sdt;
    private String ngayvao;
    private int loai;
    private String kho;
    
    public NhanVienDTO(){
        
    }

    public NhanVienDTO(String manv, String tennv, String ngaysinh, String gioitinh, String diachi, String sdt, String ngayvao, int loai, String kho) {
        this.manv = manv;
        this.tennv = tennv;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngayvao = ngayvao;
        this.loai = loai;
        this.kho = kho;
    }
    
    

    public String getManv() {
        return this.manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgayvao() {
        return ngayvao;
    }

    public void setNgayvao(String ngayvao) {
        this.ngayvao = ngayvao;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getKho() {
        return kho;
    }

    public void setKho(String kho) {
        this.kho = kho;
    }
    
    
}
