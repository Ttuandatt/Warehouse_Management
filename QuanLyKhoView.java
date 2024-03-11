/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Lop.NhaCungCap;
import View.SanPhamView;
import Lop.TrangChu;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */

public class QuanLyKhoView extends JFrame {
    public QuanLyKhoView(){
    }
    public void khoiTaoGiaoDien(){
        JFrame f = new JFrame("Nhan vien kho");
        f.setSize(1400, 850);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        //######################################################################
        // PANEL THANH DIEU HUONG
        JPanel thanhDieuHuong = new JPanel(new BorderLayout());
        thanhDieuHuong.setBackground(Color.red);
                
        //Tạo panelThongTinUser
        JPanel panelThongTinUser = new JPanel(new GridBagLayout());
        panelThongTinUser.setBackground(Color.GREEN);
        panelThongTinUser.setPreferredSize(new Dimension(200,100));
        //Tạo các label Họ tên, ID, Vị trí của nhân viên
        //Những label hoTen, ID, viTri sẽ được lấy sau từ phương thức get 
        JLabel hoTenLabel = new JLabel("Ho Ten: ");
        JLabel hoTen = new JLabel("Phan Tuan Dat");
        
        JLabel IDLabel = new JLabel("ID: ");
        JLabel ID = new JLabel("123456789");
        
        JLabel viTriLabel = new JLabel("Vi tri: ");
        JLabel viTri = new JLabel("Quan ly kho");
        
        //Set mau cho chu
        hoTenLabel.setForeground(Color.white);
        hoTen.setForeground(Color.white);
        IDLabel.setForeground(Color.white);
        ID.setForeground(Color.white);
        viTriLabel.setForeground(Color.white);
        viTri.setForeground(Color.white);
        
        //Set co chu cho labels
        Font labelFont = new Font("Arial", Font.BOLD, 15);
        hoTenLabel.setFont(labelFont);
        hoTen.setFont(labelFont);
        IDLabel.setFont(labelFont);
        ID.setFont(labelFont);
        viTriLabel.setFont(labelFont);
        viTri.setFont(labelFont);
        
        // Tạo một đối tượng GridBagConstraints để kiểm soát vị trí và kích thước của các thành phần trong panelthongTinUser.
        GridBagConstraints gbc = new GridBagConstraints();
        // Xác định vị trí của hoTenLabel trong thongTinUser (cột 0, hàng 0).
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Căn chữ bên trái
        panelThongTinUser.add(hoTenLabel, gbc);
        // Xác định vị trí của hoTen trong thongTinUser (cột 1, hàng 0).
        gbc.gridx = 1;
        panelThongTinUser.add(hoTen, gbc);
        // Xác định vị trí của IDLabel trong thongTinUser (cột 0, hàng 1).
        gbc.gridx = 0; gbc.gridy = 1;
        panelThongTinUser.add(IDLabel, gbc);
        // Xác định vị trí của ID trong thongTinUser (cột 1, hàng 1).
        gbc.gridx = 1;
        panelThongTinUser.add(ID, gbc);
        //Xác định vị trí của viTriLabel trong thongTinUser (cột 0, hàng 2).
        gbc.gridx = 0; gbc.gridy = 2;
        panelThongTinUser.add(viTriLabel, gbc);
        //xác định vị trí của viTri trong thongTinUser (cột 1, hàng 2).
        gbc.gridx = 1;
        panelThongTinUser.add(viTri, gbc);
        thanhDieuHuong.add(panelThongTinUser, BorderLayout.NORTH);
        
        //Tạo mainPanel dùng GridBagLayout để chỉnh được cách bố trí các thành phần nút chuyển hướng
        JPanel panelCenter = new JPanel(new GridLayout(15,1));
        panelCenter.setBackground(Color.decode("#56c2f5"));
        //Nút TRANG CHỦ
        JButton buttonTrangChu = new JButton("TRANG CHỦ");
        buttonTrangChu.setPreferredSize(new Dimension(250,45));
        buttonTrangChu.setBackground(Color.decode("#56c2f5"));
        buttonTrangChu.setForeground(Color.WHITE);
        // Thêm chức năng thay đổi màu khi hover vào nút "TRANG CHỦ"
        buttonTrangChu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonTrangChu.setBackground(Color.decode("#357ded")); // Đổi màu nền khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonTrangChu.setBackground(Color.decode("#56c2f5")); // Đổi màu nền khi chuột rời khỏi
            }
        });
        panelCenter.add(buttonTrangChu);
        //NÚT SẢN PHẨM
        JButton buttonSanPham = new JButton("SẢN PHẨM");
        buttonSanPham.setPreferredSize(new Dimension(250,45));
        buttonSanPham.setBackground(Color.decode("#56c2f5"));
        buttonSanPham.setForeground(Color.WHITE);
        buttonSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                buttonSanPham.setBackground(Color.decode("#357ded"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                buttonSanPham.setBackground(Color.decode("#56c2f5"));
            }
        });
        panelCenter.add(buttonSanPham);
        //NÚT NHÀ CUNG CẤP
        JButton buttonNhaCungCap = new JButton("NHÀ CUNG CẤP");
        buttonNhaCungCap.setPreferredSize(new Dimension(250,45));
        buttonNhaCungCap.setBackground(Color.decode("#56c2f5"));
        buttonNhaCungCap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                buttonNhaCungCap.setBackground(Color.decode("#357ded"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                buttonNhaCungCap.setBackground(Color.decode("#56c2f5"));
            }
        });
        panelCenter.add(buttonNhaCungCap);
        //NÚT NHẬP HÀNG
        JButton buttonNhapHang = new JButton("NHẬP HÀNG");
        buttonNhapHang.setPreferredSize(new Dimension(250,45));
        panelCenter.add(buttonNhapHang);
        //NÚT PHIẾU NHẬP
        JButton buttonPhieuNhap = new JButton("PHIẾU NHẬP");
        buttonPhieuNhap.setPreferredSize(new Dimension(250,45));
        panelCenter.add(buttonPhieuNhap);
        //NÚT XUẤT HÀNG
        JButton buttonXuatHang = new JButton("XUẤT HÀNG");
        buttonXuatHang.setPreferredSize(new Dimension(250,45));
        panelCenter.add(buttonXuatHang);
        //Tạo panelPhieuXuat để chứa nút PHIẾU XUẤT
        JButton buttonPhieuXuat = new JButton("PHIẾU XUẤT");
        buttonPhieuXuat.setPreferredSize(new Dimension(250,45));
        panelCenter.add(buttonPhieuXuat);
        thanhDieuHuong.add(panelCenter, BorderLayout.CENTER);
        //Tạo panelDangXuat ở SOUTH để chưa nút ĐĂNG XUẤT
        JButton buttonDangXuat = new JButton("ĐĂNG XUẤT");
        buttonDangXuat.setPreferredSize(new Dimension(250,45));
        thanhDieuHuong.add(buttonDangXuat, BorderLayout.SOUTH);
        mainPanel.add(thanhDieuHuong, BorderLayout.WEST);
        //######################################################################
        

        //######################################################################
        // PHAN NOI DUNG BEN PHAI
        JPanel noiDung = new JPanel(new CardLayout());
        noiDung.setBackground(Color.LIGHT_GRAY);
        mainPanel.add(noiDung, BorderLayout.CENTER);

        // Thiết lập kích thước cho các phần
        int navigationWidth = f.getWidth() / 6; // Chiều rộng của thanhDieuHuong là 1/4 của frame
        int contentWidth = f.getWidth() - navigationWidth; // Chiều rộng của noiDung
        thanhDieuHuong.setPreferredSize(new Dimension(navigationWidth, f.getHeight())); // Đặt kích thước cho thanhDieuHuong
        noiDung.setPreferredSize(new Dimension(contentWidth, f.getHeight())); // Đặt kích thước cho noiDung
        
        // Định danh cho trang chủ
        final String trangchu = "TRANG_CHU";
        final String sanpham = "SAN_PHAM";
        final String nhacungcap = "NHA_CUNG_CAP";
        
        final String dangxuat = "DANG_XUAT";
        // Thiết lập action listener cho buttonTrangChu
        buttonTrangChu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo một đối tượng của lớp SanPham
                TrangChu trangChuObj = new TrangChu();
                // Thêm giao diện sản phẩm vào noiDung
                noiDung.add(trangChuObj, trangchu);
                // Chuyển đến giao diện trang chủ khi nút được nhấp
                CardLayout cardLayout = (CardLayout) noiDung.getLayout();
                cardLayout.show(noiDung, trangchu);
            }
        });
        // Thiết lập action listener cho buttonSanPham
        buttonSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SanPhamView sanPhamObj = new SanPhamView();
                sanPhamObj.giaoDienSanPham();
                noiDung.add(sanPhamObj, sanpham);
                CardLayout cardLayout = (CardLayout) noiDung.getLayout();
                cardLayout.show(noiDung, sanpham);
            }
        });
        buttonNhaCungCap.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                NhaCungCap nhaCungCapObj = new NhaCungCap();
                nhaCungCapObj.setBackground(Color.red);
                noiDung.add(nhaCungCapObj, nhacungcap);
                CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                cardLayout.show(noiDung, nhacungcap);
            }
        });
        buttonDangXuat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int choice = JOptionPane.showConfirmDialog(f, "Đăng xuất?", "Đăng xuất", JOptionPane.OK_CANCEL_OPTION);
                if(choice==JOptionPane.OK_OPTION){  //Nếu user click ok, thì đóng frame ứng dụng, mở cửa sổ login
                    f.dispose();
                    LoginView loginFormObj = new LoginView();
                    noiDung.add(loginFormObj.giaoDienLogin(), dangxuat);
                    CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                    cardLayout.show(noiDung, dangxuat);
                }
                
            }
        });
        // Thêm giao diện trang chủ vào JPanel noiDung với định danh TRANG_CHU
        // Ví dụ: JPanel trangChuPanel là giao diện của trang chủ
        JPanel trangChuPanel = new JPanel();
        JLabel labelTrangChu = new JLabel("This is the Home page");
        trangChuPanel.add(labelTrangChu);
        noiDung.add(trangChuPanel, trangchu);

        //######################################################################

        f.add(mainPanel);
        f.setVisible(true);
    }
}

