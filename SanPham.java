/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lop;

public class SanPham {
    private String maMay;
    private String tenMay;
    private int soLuong;
    private int gia;
    private String boXuLy;
    private String boNho;
    private int ram;
    private String nhaCungCap;

    public SanPham(String maMay, String tenMay, int soLuong, int gia, String boXuLy, String boNho, int ram, String nhaCungCap) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.soLuong = soLuong;
        this.gia = gia;
        this.boXuLy = boXuLy;
        this.boNho = boNho;
        this.ram = ram;
        this.nhaCungCap = nhaCungCap;
    }

    // Getters and Setters
    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getBoXuLy() {
        return boXuLy;
    }

    public void setBoXuLy(String boXuLy) {
        this.boXuLy = boXuLy;
    }

    public String getBonho() {
        return boNho;
    }

    public void setBonho(String boNho) {
        this.boNho = boNho;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}
