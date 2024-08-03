/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class KhoHangDTO {
    private String maKho;
    private String tenKho;
    private String diachi;
    private String sdt;
    private int trangthai;
    public KhoHangDTO() {
    }

    public KhoHangDTO(String maKho, String tenKho, String diachi, String sdt) {
        this.maKho = maKho;
        this.tenKho = tenKho;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public KhoHangDTO(String maKho, String tenKho, String diachi, String sdt, int trangthai) {
        this.maKho = maKho;
        this.tenKho = tenKho;
        this.diachi = diachi;
        this.sdt = sdt;
        this.trangthai = trangthai;
    }
    
    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
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
    
    
    
}
