/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public class SanPhamModel {
    private String maMay;
    private String tenMay;
    private int soLuong;
    private double gia;
    private String boXuLy;
    private int ram;
    private int boNho;
    
    //Constructor
    public SanPhamModel(){}
    public SanPhamModel(String maMay, String tenMay, int soLuong, double gia, String boXuLy, int ram, int boNho){
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.soLuong = soLuong;
        this.gia = gia;
        this.boXuLy = boXuLy;
        this.ram = ram;
        this.boNho = boNho;
    }
    //getter,setter

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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getBoXuLy() {
        return boXuLy;
    }

    public void setBoXuLy(String boXuLy) {
        this.boXuLy = boXuLy;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getBoNho() {
        return boNho;
    }

    public void setBoNho(int boNho) {
        this.boNho = boNho;
    }
    
}
