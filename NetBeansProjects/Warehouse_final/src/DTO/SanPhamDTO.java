        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class SanPhamDTO {
    private String maMay;
    private String tenMay;
    private int soLuong;
    private int gia;
    private String boXuLy;
    private String ram;
    private String boNho;
    private String gpu;
    private String kichthuocman;
    private String nhaCungCap;
    private String maKho;
    private int trangThai;

    //Constructor
    public SanPhamDTO(){
        
    }
    public SanPhamDTO(String maMay, String tenMay, int soLuong, int gia, String boXuLy, String boNho, String ram, String gpu, String kichthuocman, String nhaCungCap, String maKho) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.soLuong = soLuong;
        this.gia = gia;
        this.boXuLy = boXuLy;
        this.ram = ram;
        this.boNho = boNho;
        this.gpu = gpu;
        this.kichthuocman = kichthuocman;
        this.nhaCungCap = nhaCungCap;
        this.maKho = maKho;
    }
    
    public SanPhamDTO(int trangthai){
        this.trangThai = trangthai;
    }
    
    public SanPhamDTO(String maMay, String tenMay, int soLuong, int gia, String nhaCungCap) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.soLuong = soLuong;
        this.gia = gia;
        this.nhaCungCap = nhaCungCap;
    }
    
    public SanPhamDTO(String maMay, String tenMay, int soLuong, int gia, String boXuLy, String vga, String nhaCungCap) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.soLuong = soLuong;
        this.gia = gia;
        this.boXuLy = boXuLy;
        this.gpu = vga;
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

    public String getBoNho() {
        return boNho;
    }

    public void setBoNho(String boNho) {
        this.boNho = boNho;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGPU() {
        return gpu;
    }

    public void setGPU(String gpu) {
        this.gpu = gpu;
    }

    public String getKichthuocman() {
        return kichthuocman;
    }

    public void setKichthuocman(String kichthuocman) {
        this.kichthuocman = kichthuocman;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
