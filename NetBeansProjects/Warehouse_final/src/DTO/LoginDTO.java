/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class LoginDTO {
    
    private String manv;
    private String password;
    private int loai;
    
    //Constructor
    public LoginDTO(){
    }
    public LoginDTO(String manv, String password){
        this.manv = manv;
        this.password = password;
    }
    public LoginDTO(String manv, String password, int loai){
        this.manv = manv;
        this.password = password;
        this.loai = loai;
        
    }   
    //getter, setter

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }
}
