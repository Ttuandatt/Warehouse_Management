package DTO;

import java.util.ArrayList;
import java.time.*; 

public class PhieuNhapDTO {
	private String maphieu;
	private String mancc;
	private String manguoitao;
	private String makho;
	private LocalDate ngaytao;
	private int tongtien;
	private int trangthai;

	public PhieuNhapDTO() {
	}

	public PhieuNhapDTO(String maphieu, String mancc, String manguoitao, String makho, LocalDate ngaytao, int tongtien,
			int trangthai) {
		super();
		this.maphieu = maphieu;
		this.mancc = mancc;
		this.manguoitao = manguoitao;
		this.makho = makho;
		this.ngaytao = ngaytao;
		this.tongtien = tongtien;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getMaphieu() {
		return maphieu;
	}

	public void setMaphieu(String maphieu) {
		this.maphieu = maphieu;
	}

	public String getManguoitao() {
		return manguoitao;
	}

	public int getTongTien() {
		return this.tongtien;
	}

	public void setTongTien(int tongtien) {
		this.tongtien = tongtien;
	}

	public void setManguoitao(String manguoitao) {
		this.manguoitao = manguoitao;
	}

	public String getMakho() {
		return makho;
	}

	public void setMakho(String makho) {
		this.makho = makho;
	}

	public LocalDate getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(LocalDate ngaytao) {
		this.ngaytao = ngaytao;
	}

	public String getMancc() {
		return mancc;
	}

	public void setMancc(String mancc) {
		this.mancc = mancc;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public void setTrangThai(int trangthai) {
		this.trangthai = trangthai;
	}

	public int getTrangThai() {
		return this.trangthai;
	}
}