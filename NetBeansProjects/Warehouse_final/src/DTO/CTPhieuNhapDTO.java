package DTO;

public class CTPhieuNhapDTO {
	private String mapn;
	private String masp;
	private String tensp;
	private int soluong;
	private int gia;
        private int trangthai;
	public CTPhieuNhapDTO() {
		
	}
	public CTPhieuNhapDTO(String mapn, String masp, String tensp, int soluong, int gia) {
		super();
		this.mapn = mapn;
		this.masp = masp;
		this.tensp = tensp;
		this.soluong = soluong;
		this.gia = gia;
	}
	public String getMapn() {
		return mapn;
	}
	public void setMapn(String mapn) {
		this.mapn = mapn;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	
}