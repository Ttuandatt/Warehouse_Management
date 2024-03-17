package Controller;

import View.LoginView;
import View.NhanVienKhoView;
import Model.LoginModel;
import View.QuanLyKhoView;
import javax.swing.JOptionPane;
public class LoginController {
    public LoginView view;
    //Constructor
    public LoginController(LoginView view){
        this.view = view;
    }
    public void checkAndLogin(LoginModel user){
    if((user.getUsername().equals("admin")) && user.getPassword().equals("123")){
        QuanLyKhoView qlk = new QuanLyKhoView();
//        qlk.khoiTaoGiaoDien(); // Hiển thị frame quanLyKho, trường hợp constructor của QuanLyKhoView không có gọi sẵn hàm khoiTaoGiaoDien
//còn hiện tại constructor của QuanLyKhoView gọi sẵn r nên khỏi  gọi
        // Đóng frame đăng nhập
        view.closeLoginFrame();
    }
    else if(user.getUsername().equals("nv1") && user.getPassword().equals("123")){
        NhanVienKhoView nvk = new NhanVienKhoView();
        nvk.khoiTaoGiaoDien(); // Đảm bảo khởi tạo giao diện cho frame nhanVienKho
        // Đóng frame đăng nhập
        view.closeLoginFrame();
    }
    else{
       JOptionPane.showMessageDialog(null, "Sai thông tin đăng nhập!", "Thông báo", JOptionPane.ERROR_MESSAGE);
    }
}
    
}
