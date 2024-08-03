/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class PhieuXuatDTO {
    private String mapx;
    private String manguoitao;
    private String makho;
    private String makhachhang;
    private LocalDate thoigiantao; 
    private int tongtien;
    private int trangThai;
//    private ArrayList<CTPhieuXuatDTO> ctPhieuXuat;

    public PhieuXuatDTO() {}
    
    public PhieuXuatDTO(String mapx) {
        this.mapx = mapx;
        
    }

    public PhieuXuatDTO(String mapx, String manguoitao, String makho, String makhachhang, LocalDate thoigiantao, int tongtien, int trangThai) {
        this.mapx = mapx;
        this.manguoitao = manguoitao;
        this.makho = makho;
        this.makhachhang = makhachhang;
        this.thoigiantao = thoigiantao;
        this.tongtien = tongtien;
        this.trangThai = trangThai;
    }
    
    public PhieuXuatDTO(String mapx, String manguoitao, String makho, String makhachhang, LocalDate thoigiantao, int tongtien) {
        this.mapx = mapx;
        this.manguoitao = manguoitao;
        this.makho = makho;
        this.makhachhang = makhachhang;
        this.thoigiantao = thoigiantao;
        this.tongtien = tongtien;
    }
    
    public PhieuXuatDTO(String mapx, String manguoitao, LocalDate thoigiantao, int tongtien) {
        this.mapx = mapx;
        this.manguoitao = manguoitao;
        this.thoigiantao = thoigiantao;
        this.tongtien = tongtien;

    }
    
    public PhieuXuatDTO(String mapx, String manguoitao, LocalDate thoigiantao) {
        this.mapx = mapx;
        this.manguoitao = manguoitao;
        this.thoigiantao = thoigiantao;
    }


    public String getMapx() {
        return mapx;
    }

    public void setMapx(String mapx) {
        this.mapx = mapx;
    }

    public String getManguoitao() {
        return manguoitao;
    }

    public void setManguoitao(String manguoitao) {
        this.manguoitao = manguoitao;
    }

    public LocalDate getThoigiantao() {
        return thoigiantao;
    }

    public void setThoigiantao(LocalDate thoigiantao) {
        this.thoigiantao = thoigiantao;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMakho() {
        return makho;
    }

    public void setMakho(String makho) {
        this.makho = makho;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }
}
