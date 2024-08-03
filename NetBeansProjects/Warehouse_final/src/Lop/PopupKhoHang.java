/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lop;

import DTO.KhoHangDTO;
import BUS.KhoHangBUS;
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

public class PopupKhoHang {
    JLabel lbmakho, lbtenkho, lbdiachi, lbsdt;
    JTextField tfmakho, tftenkho, tfdiachi, tfsdt;
    KhoHangBUS khoBUS = new KhoHangBUS();
    public PopupKhoHang(String title, String ban, String loai){
        JFrame f = new JFrame(title);
        
        f.setLayout(new GridBagLayout());
        
        JPanel banner = new JPanel();
        banner.setBackground(Color.decode("#56c2f5"));
        JPanel content = new JPanel();
        content.setBackground(Color.GREEN);
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
        JLabel lb = new JLabel("THÊM KHO");
        Font font = new Font("Arial", Font.BOLD, 15);
        lb.setFont(font);
        lb.setForeground(Color.WHITE);
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.weightx = 1.0;
        gbcLabel.weighty = 1.0;
        banner.add(lb, gbcLabel);
        
        JPanel pnMa, pnTen, pnDiaChi, pnSdt, pnCancel, pnOK;
        pnMa = new JPanel();
        pnMa.setBackground(Color.WHITE);
        pnTen = new JPanel();
        pnTen.setBackground(Color.WHITE);
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
        content.add(pnTen, gbc);
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
        
        lbmakho = new JLabel("Mã kho");
        lbtenkho = new JLabel("Tên kho");
        lbdiachi = new JLabel("Địa chỉ");
        lbsdt = new JLabel("SĐT");
        
        tfmakho = new JTextField();
        tftenkho = new JTextField();
        tfdiachi = new JTextField();
        tfsdt = new JTextField();
        
        lbmakho.setBounds(30,5,100,20);
        tfmakho.setBounds(30,25,180,25);
        pnMa.setLayout(null);
        pnMa.add(lbmakho);  pnMa.add(tfmakho);
        
        lbtenkho.setBounds(30,5,110,20);
        tftenkho.setBounds(30,25,180,25);
        pnTen.setLayout(null);
        pnTen.add(lbtenkho);    pnTen.add(tftenkho);
        
        lbdiachi.setBounds(30,5,110,20);
        tfdiachi.setBounds(30,25,180,25);
        pnDiaChi.setLayout(null);
        pnDiaChi.add(lbdiachi); pnDiaChi.add(tfdiachi);
        
        lbsdt.setBounds(30,5,110,20);
        tfsdt.setBounds(30,25,180,25);
        pnSdt.setLayout(null);
        pnSdt.add(lbsdt);   pnSdt.add(tfsdt);
        
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
                    if(tfmakho.getText().isEmpty() || tftenkho.getText().isEmpty() || tfdiachi.getText().isEmpty() || tfsdt.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin");
                    } else{
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm kho hàng?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
                        if(dialogResult == JOptionPane.OK_OPTION){

                            String maKho = tfmakho.getText();
                            String tenKho = tftenkho.getText();
                            String diaChi = tfdiachi.getText();
                            String sdt = tfsdt.getText();

                            // Kiểm tra định dạng của số điện thoại
                            if (!isValidPhoneNumber(sdt)) {
                                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                                return;
                            }

                            KhoHangDTO khoDTO = new KhoHangDTO();
                            khoDTO.setMaKho(maKho);
                            khoDTO.setTenKho(tenKho);
                            khoDTO.setDiachi(diaChi);
                            khoDTO.setSdt(sdt);

                            JOptionPane.showMessageDialog(null, khoBUS.addKhoHang(khoDTO));
                        }
                    }
                }
            });
        } else if(loai.equals("fix")){
            confirm.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(tfmakho.getText().isEmpty() || tftenkho.getText().isEmpty() || tfdiachi.getText().isEmpty() || tfsdt.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin");
                    } else{
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa thông tin kho hàng?");
                        if(dialogResult == JOptionPane.OK_OPTION){
                            String maKho = tfmakho.getText();
                            String tenKho = tftenkho.getText();
                            String diaChi = tfdiachi.getText();
                            String sdt = tfsdt.getText();

                            // Kiểm tra định dạng của số điện thoại
                            if (!isValidPhoneNumber(sdt)) {
                                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                                return;
                            }

                            KhoHangDTO khoDTO = new KhoHangDTO();
                            khoDTO.setMaKho(maKho);
                            khoDTO.setTenKho(tenKho);
                            khoDTO.setDiachi(diaChi);
                            khoDTO.setSdt(sdt);

                            JOptionPane.showMessageDialog(null, khoBUS.updateKhoHang(khoDTO));
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
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Kiểm tra độ dài và ký tự
        if (phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]+")) {
            return false;
        }
        // Kiểm tra số bắt đầu
        if (!phoneNumber.startsWith("0")) {
            return false;
        }
        return true;
    }
    private void resetValues(){
        tfmakho.setText("");
        tftenkho.setText("");
        tfdiachi.setText("");
        tfsdt.setText("s");
    }
}