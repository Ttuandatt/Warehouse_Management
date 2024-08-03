/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoginDAO;
import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO;
import DTO.LoginDTO;
import DTO.NhanVienDTO;
import GUI.LoginGUI;
import GUI.NhanVienKhoView;
import GUI.QuanLyKhoView;
import javax.swing.JOptionPane;

public class LoginBUS {
    private LoginDAO loginDAO;
    private NhanVienDAO nvDAO = new NhanVienDAO();
    public static String hoten = "";
    public static String id = "";
    public static int loai;
    public static String makho = "";
    public LoginBUS(){
        this.loginDAO = new LoginDAO();
    }
    public String getId() {
    	return this.id;
    }
    public void checkAndLogin(LoginDTO user, LoginGUI view){
    try {
        if (loginDAO.openConnection()) {
            int checkResult = loginDAO.checkLogin(user);
            loai = user.getLoai();

            switch (checkResult) {
                case 1:
                    // Kiểm tra loại tài khoản để hiển thị giao diện phù hợp
                    LoginDTO account = loginDAO.getAccountInformation(user.getManv(), user.getPassword());
                    NhanVienDTO thongTinUser = nvDAO.getByID(account.getManv());
                    
                    hoten = thongTinUser.getTennv();
                    id = thongTinUser.getManv();
                    loai = thongTinUser.getLoai();
                    makho = thongTinUser.getKho();
                    
                    if (loai == 0) {
                        QuanLyKhoView qlk = new QuanLyKhoView();
                        qlk.capNhatThongTinNguoiDung(hoten, id, loai);
                    } else if (loai == 1) {
                        NhanVienKhoView nvk = new NhanVienKhoView();
                        nvk.capNhatThongTinNguoiDung(hoten, id, loai);
                    }
                    
                    view.closeLoginFrame();
                    break;
                
                case 2:
                    JOptionPane.showMessageDialog(null, "Nhân viên chưa có tài khoản");
                    break;
                
                case 3:
                    JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại");
                    break;
                
                case 4:
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu");
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Lỗi không xác định", "Lỗi", JOptionPane.WARNING_MESSAGE);
                    break;
            }
            loginDAO.closeConnection();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
}

    
}
