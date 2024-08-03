package DTO;

import java.sql.Timestamp;
import java.util.ArrayList;

    /**
     *
     * @author PC
     */
public class CTPhieuXuatDTO extends PhieuXuatDTO {
    private String maSP;
    private String tenSP;
    private int soLuongSP;
    private int giaSP;

    public CTPhieuXuatDTO() {
    }

    public CTPhieuXuatDTO(String mapx, String maSP, String tenSP, int soLuongSP, int giaSP) {
        super(mapx);
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuongSP = soLuongSP;
        this.giaSP = giaSP;
    }
    
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }
        
        
}
