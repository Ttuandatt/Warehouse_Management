/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lop;

import BUS.TaiKhoanBUS;
import BUS.NhanVienBUS;
import DTO.TaiKhoanDTO;
import DTO.NhanVienDTO;
import DAO.NhanVienDAO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author ACER
 */
public class PopupTaiKhoan {
    JLabel  lbMaNV, lbPassword;
    JTextField  tfMaNV, tfPassword;
    TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    NhanVienDAO nvDAO = new NhanVienDAO();
    NhanVienDTO nv;
    public PopupTaiKhoan(String title, String ban, String loai){
        JFrame f = new JFrame(title);
        
        f.setLayout(new GridBagLayout());
        
        JPanel banner = new JPanel();
        banner.setBackground(Color.decode("#56c2f5"));
        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);
        content.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 0.15;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        f.add(banner, gbc);
        gbc.weighty = 0.85;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 1;
        f.add(content, gbc);
        
        banner.setLayout(new GridBagLayout());
        JLabel lb = new JLabel(ban);
        Font font = new Font("Arial", Font.BOLD, 15);
        lb.setFont(font);
        lb.setForeground(Color.WHITE);
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.weightx = 1.0;
        gbcLabel.weighty = 1.0;
        banner.add(lb, gbcLabel);
        
        JPanel pnMa, pnPassword, pnDiaChi, pnSdt, pnCancel, pnOK;
        pnMa = new JPanel();
        pnMa.setBackground(Color.WHITE);
        pnPassword = new JPanel();
        pnPassword.setBackground(Color.WHITE);
        pnDiaChi = new JPanel();
        pnDiaChi.setBackground(Color.WHITE);
        pnSdt = new JPanel();
        pnSdt.setBackground(Color.WHITE);
        pnCancel = new JPanel();
        pnCancel.setBackground(Color.WHITE);
        pnOK = new JPanel();
        pnOK.setBackground(Color.WHITE);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(pnMa, gbc);
        gbc.gridy = 1;
        content.add(pnPassword, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        content.add(pnDiaChi, gbc);
        gbc.gridy = 1;
        content.add(pnSdt, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        content.add(pnCancel, gbc);
        gbc.gridx = 1;
        content.add(pnOK, gbc);
        
        
        lbPassword = new JLabel("Mật khẩu");
        lbMaNV = new JLabel("Mã NV");
        
        tfPassword = new JTextField();
        tfMaNV = new JTextField();
        
        
        
        lbPassword.setBounds(30,5,110,20);
        tfPassword.setBounds(30,25,180,25);
        pnPassword.setLayout(null);
        pnPassword.add(lbPassword);    pnPassword.add(tfPassword);
        
        
        lbMaNV.setBounds(30,5,110,20);
        tfMaNV.setBounds(30,25,180,25);
        pnMa.setLayout(null);
        pnMa.add(lbMaNV);   pnMa.add(tfMaNV);
        
        JButton cancel, confirm;
        cancel = new JButton("Cancel");
        cancel.setBounds(135,50,75,30);
        cancel.setBackground(Color.decode("#E42535"));
        cancel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                cancel.setBackground(Color.decode("#EB5C68"));   //Đổi màu khi hover chuột vào nứt đăng nhập
                cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                cancel.setBackground(Color.decode("#E42535"));   //Đổi màu khi hover chuột khỏi nút đăng nhập
            }
        });
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int choice = JOptionPane.showConfirmDialog(f, "Bạn có chắc muốn hủy?", "Cancel", JOptionPane.OK_CANCEL_OPTION);
                if(choice==JOptionPane.OK_OPTION){
                    resetValues();
                }
            }
        });
        pnCancel.setLayout(null);
        pnCancel.add(cancel);
        confirm = new JButton("OK");
        confirm.setBounds(30,50,75,30);
        confirm.setBackground(Color.decode("#56c2f5"));
        confirm.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                confirm.setBackground(Color.decode("#bde2f2"));   //Đổi màu khi hover chuột vào nứt đăng nhập
                confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                confirm.setBackground(Color.decode("#56c2f5"));   //Đổi màu khi hover chuột khỏi nút đăng nhập
            }
        });
        if(loai.equals("add")){
            confirm.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(tfPassword.getText().isEmpty() || tfMaNV.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");                
                    }else{
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm tài khoản?");
                        if(dialogResult == JOptionPane.OK_OPTION){
                            String password = tfPassword.getText();
                            String manv = tfMaNV.getText();
                            nv = nvDAO.getByID(manv);
                            int type = nv.getLoai();

                            TaiKhoanDTO tkDTO = new TaiKhoanDTO();
                            tkDTO.setMatKhau(password);
                            tkDTO.setLoai(type);
                            tkDTO.setMaNV(manv);

                            JOptionPane.showMessageDialog(null, tkBUS.addTaiKhoan(tkDTO));
                        }
                    }
                }
        });
        }
        else if(loai.equals("fix")){
            confirm.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(tfPassword.getText().isEmpty() || tfMaNV.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");                
                    }else{
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa thông tin tài khoản?");
                        if(dialogResult == JOptionPane.OK_OPTION){
                            String password = tfPassword.getText();
                            String manv = tfMaNV.getText();

                            TaiKhoanDTO tkDTO = new TaiKhoanDTO();
                            tkDTO.setMatKhau(password);
                            tkDTO.setMaNV(manv);

                            JOptionPane.showMessageDialog(null, tkBUS.updateTaiKhoan(tkDTO));
                        }
                    }
                }
            });
        }
        pnOK.setLayout(null);
        pnOK.add(confirm);
        
        f.setSize(500,400);
        f.setResizable(false);
        f.setVisible(true);
    }
    
    private void resetValues(){
        tfPassword.setText("");
        tfMaNV.setText("");
    }
    
}
