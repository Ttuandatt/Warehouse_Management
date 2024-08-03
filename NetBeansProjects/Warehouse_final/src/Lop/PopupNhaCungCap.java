/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lop;

import DTO.NhaCungCapDTO;
import BUS.NhaCungCapBUS;
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
public class PopupNhaCungCap{
    JLabel lbmancc, lbtenncc, lbdiachi, lbsdt;
    JTextField tfmancc, tftenncc, tfdiachi, tfsdt;
    NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    public PopupNhaCungCap(String title, String ban, String loai){
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
        JLabel lb = new JLabel("THÊM NHÀ CUNG CẤP");
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
        
        lbmancc = new JLabel("Mã nhà cung cấp");
        lbtenncc = new JLabel("Tên nhà cung cấp");
        lbdiachi = new JLabel("Địa chỉ");
        lbsdt = new JLabel("SĐT");
        
        tfmancc = new JTextField();
        tftenncc = new JTextField();
        tfdiachi = new JTextField();
        tfsdt = new JTextField();
        
        lbmancc.setBounds(30,5,100,20);
        tfmancc.setBounds(30,25,180,25);
        pnMa.setLayout(null);
        pnMa.add(lbmancc);  pnMa.add(tfmancc);
        
        lbtenncc.setBounds(30,5,110,20);
        tftenncc.setBounds(30,25,180,25);
        pnTen.setLayout(null);
        pnTen.add(lbtenncc);    pnTen.add(tftenncc);
        
        lbdiachi.setBounds(30,5,110,20);
        tfdiachi.setBounds(30,25,180,25);
        pnDiaChi.setLayout(null);
        pnDiaChi.add(lbdiachi); pnDiaChi.add(tfdiachi);
        
        lbsdt.setBounds(30,5,110,20);
        tfsdt.setBounds(30,25,180,25);
        pnSdt.setLayout(null);
        pnSdt.add(lbsdt);   pnSdt.add(tfsdt);
        
        JButton cancelButton, confirmButton;
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(135,50,75,30);
        cancelButton.setBackground(Color.decode("#E42535"));
        cancelButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                cancelButton.setBackground(Color.decode("#EB5C68"));   //Đổi màu khi hover chuột vào nứt đăng nhập
                cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                cancelButton.setBackground(Color.decode("#E42535"));   //Đổi màu khi hover chuột khỏi nút đăng nhập
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int choice = JOptionPane.showConfirmDialog(f, "Bạn có chắc muốn hủy?", "Cancel", JOptionPane.OK_CANCEL_OPTION);
                if(choice==JOptionPane.OK_OPTION){
                    resetValues();
                }
            }
        });
        pnCancel.setLayout(null);
        pnCancel.add(cancelButton);
        confirmButton = new JButton("OK");
        confirmButton.setBounds(30,50,75,30);
        confirmButton.setBackground(Color.decode("#56c2f5"));
        confirmButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                confirmButton.setBackground(Color.decode("#bde2f2"));   //Đổi màu khi hover chuột vào nứt đăng nhập
                confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                confirmButton.setBackground(Color.decode("#56c2f5"));   //Đổi màu khi hover chuột khỏi nút đăng nhập
            }
        });
        if (loai.equals("add")) {
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tfmancc.getText().isEmpty() || tftenncc.getText().isEmpty() || tfdiachi.getText().isEmpty() || tfsdt.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                    } else {
                        int dialogResult = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thêm nhà cung cấp?");
                        if(dialogResult == JOptionPane.OK_OPTION){
                            String maNCC = tfmancc.getText();
                            String tenNCC = tftenncc.getText();
                            String diaChiNCC = tfdiachi.getText();
                            String sdt = tfsdt.getText();

                            // Kiểm tra định dạng của số điện thoại
                            if (!isValidPhoneNumber(sdt)) {
                                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                                return;
                            }

                            NhaCungCapDTO nccDTO = new NhaCungCapDTO();
                            nccDTO.setMaNCC(maNCC);
                            nccDTO.setTenNCC(tenNCC);
                            nccDTO.setDiaChiNCC(diaChiNCC);
                            nccDTO.setSdt(sdt);

                            JOptionPane.showMessageDialog(null, nccBUS.addNhaCungCap(nccDTO));
                        }
                    }
                }
            });
        }
        else if (loai.equals("fix")) {
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                if (tfmancc.getText().isEmpty() || tftenncc.getText().isEmpty() || tfdiachi.getText().isEmpty() || tfsdt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                } else {
                    int dialogResult = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thêm nhà cung cấp?");
                    if(dialogResult == JOptionPane.OK_OPTION){
                        String maNCC = tfmancc.getText();
                        String tenNCC = tftenncc.getText();
                        String diaChiNCC = tfdiachi.getText();
                        String sdt = tfsdt.getText();

                        // Kiểm tra định dạng của số điện thoại
                        if (!isValidPhoneNumber(sdt)) {
                            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                            return;
                        }

                        NhaCungCapDTO nccDTO = new NhaCungCapDTO();
                        nccDTO.setMaNCC(maNCC);
                        nccDTO.setTenNCC(tenNCC);
                        nccDTO.setDiaChiNCC(diaChiNCC);
                        nccDTO.setSdt(sdt);

                        JOptionPane.showMessageDialog(null, nccBUS.updateNhaCungCap(nccDTO));
                    }
                }
            }
        });
    }
        pnOK.setLayout(null);
        pnOK.add(confirmButton);
        
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
        tfmancc.setText("");
        tftenncc.setText("");
        tfdiachi.setText("");
        tfsdt.setText("s");
    }
    
}