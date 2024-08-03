/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lop;

import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class PopupPhieuXuat {
    private JLabel lbMaSP, lbTenSP, lbSoLuong,lbGia,lbBoXuLy,lbBoNho,lbRam, lbGPU, lbSize, lbNhaCC;
    private JTextField tfMaSP, tfTenSP, tfSoLuong,tfGia, tfGPU, tfSize, tfNhaCC;
    private JComboBox<String> cb1;
    private JComboBox<String> cb2;
    private JComboBox<String> cb3;
    SanPhamBUS spBUS = new SanPhamBUS();
    public PopupPhieuXuat(String title, String ban, String loai){  //ban: banner viết tắt nhưng vì trùng với JPanel bên dưới nên để là ban
        JFrame f = new JFrame(title);

        f.setLayout(new GridBagLayout());
        f.setSize(800, 500);

        JPanel banner = new JPanel();
        banner.setBackground(Color.decode("#56c2f5"));
        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);
        // Tạo các ràng buộc cho JPanel banner
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 0.15;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        f.add(banner, gbc);
        gbc.gridy = 1;
        gbc.weighty = 0.85;
        f.add(content, gbc);

        //Thêm Label vào banner
        banner.setLayout(new GridBagLayout());
        JLabel lb = new JLabel(ban);
        Font lbFont = new Font("Arial", Font.BOLD, 20);
        lb.setFont(lbFont);
        lb.setForeground(Color.WHITE);
        // Căn giữa JLabel trong JPanel banner
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.weightx = 1.0;
        gbcLabel.weighty = 1.0;
        banner.add(lb, gbcLabel);

        //Thêm các textfields, comboboxes vào panel content
        content.setLayout(new GridBagLayout());
            
        //Tạo các panel chứa các label, textfield, combox
        JPanel pnMa, pnTen, pnSoluong, pnGia, pnBoXuLy, pnBoNho,pnRam,pnGPU,pnSize,pnNhaCC, pnOption;
    
        pnMa = new JPanel();
        pnMa.setBackground(Color.WHITE);
        pnTen = new JPanel();
        pnTen.setBackground(Color.WHITE);
        pnSoluong = new JPanel();
        pnSoluong.setBackground(Color.WHITE);
        pnGia = new JPanel();
        pnGia.setBackground(Color.WHITE);
        pnBoXuLy = new JPanel();
        pnBoXuLy.setBackground(Color.WHITE);
        pnBoNho = new JPanel();
        pnBoNho.setBackground(Color.WHITE);
        pnRam = new JPanel();
        pnRam.setBackground(Color.WHITE);
        pnGPU = new JPanel();
        pnGPU.setBackground(Color.WHITE);
        pnSize = new JPanel();
        pnSize.setBackground(Color.WHITE);
        pnNhaCC = new JPanel();
        pnNhaCC.setBackground(Color.WHITE);
        pnOption = new JPanel();
        pnOption.setBackground(Color.WHITE);
    
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(pnMa, gbc);
        gbc.gridy = 1;
        content.add(pnTen, gbc);
        gbc.gridy = 2;
        content.add(pnSoluong, gbc);
        gbc.gridy = 3;
        content.add(pnGia, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        content.add(pnBoXuLy, gbc);
        gbc.gridy  = 1;
        content.add(pnBoNho, gbc);
        gbc.gridy = 2;
        content.add(pnRam, gbc);
        gbc.gridy = 3;
        content.add(pnGPU, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        content.add(pnSize, gbc);
        gbc.gridy = 1;
        content.add(pnNhaCC, gbc);
        gbc.gridy = 3;
        content.add(pnOption, gbc);
            
        //Tạo và thêm các label, textfield, combobox
        lbMaSP = new JLabel("Mã sản phẩm");
        lbTenSP =  new JLabel("Tên sản phẩm");
        lbSoLuong = new JLabel("Số lượng");
        lbGia = new JLabel("Giá");
        lbBoXuLy = new JLabel("Bộ xử lý");
        lbBoNho = new JLabel("Bộ nhớ");
        lbRam = new JLabel("RAM");
        lbGPU = new JLabel("GPU");
        lbSize = new JLabel("Kích thước màn");
        lbNhaCC = new JLabel("Nhà cung cấp");
        
        tfMaSP = new JTextField();
        tfTenSP = new JTextField();
        tfSoLuong = new JTextField();
        tfGia = new JTextField();
        tfGPU = new JTextField();
        tfSize = new JTextField();
        tfNhaCC = new JTextField();
    
        lbMaSP.setBounds(40,5,90,20);
        tfMaSP.setBounds(40,25,180,30);
        pnMa.setLayout(null);
        pnMa.add(lbMaSP);   pnMa.add(tfMaSP);
    
        lbTenSP.setBounds(40,5,90,20);
        tfTenSP.setBounds(40,25,180,30);
        pnTen.setLayout(null);
        pnTen.add(lbTenSP); pnTen.add(tfTenSP);
    
        lbSoLuong.setBounds(40,5,90,20);
        tfSoLuong.setBounds(40,25,180,30);
        pnSoluong.setLayout(null);
        pnSoluong.add(lbSoLuong); pnSoluong.add(tfSoLuong);
    
        lbGia.setBounds(40,5,90,20);
        tfGia.setBounds(40,25,180,30);
        pnGia.setLayout(null);
        pnGia.add(lbGia); pnGia.add(tfGia);
        
        lbGPU.setBounds(60,5,90,20);
        tfGPU.setBounds(60,25,180,30);
        pnGPU.setLayout(null);
        pnGPU.add(lbGPU); pnGPU.add(tfGPU);
        
        lbSize.setBounds(60,5,90,20);
        tfSize.setBounds(60,25,180,30);
        pnSize.setLayout(null);
        pnSize.add(lbSize); pnSize.add(tfSize);
    
        
        //Set các combobox
        lbBoXuLy.setBounds(60,5,90,20);
        String[] combo1 = {"Tất cả","Intel Xeon","Intel Core i5","Intel Core i7", "Intel Core i9", "AMD Ryzen 5", "AMD Ryzen 7", "Apple M1 Chip"};
        cb1 = new JComboBox(combo1);
        cb1.setBounds(60,25,120,30);
        pnBoXuLy.setLayout(null);
        pnBoXuLy.add(lbBoXuLy); pnBoXuLy.add(cb1);
    
        lbBoNho.setBounds(60,5,90,20);
        String[] combo2 = {"Tất cả","256GB","512GB"};
        cb2 = new JComboBox(combo2);
        cb2.setBounds(60,25,120,30);
        pnBoNho.setLayout(null);
        pnBoNho.add(lbBoNho);   pnBoNho.add(cb2);
    
        lbRam.setBounds(60,5,90,20);
        String[] combo3 = {"Tất cả", "8GB", "16GB", "32GB"};
        cb3 = new JComboBox(combo3);
        cb3.setBounds(60,25,120,30);
        pnRam.setLayout(null);
        pnRam.add(lbRam);   pnRam.add(cb3);
    
        lbNhaCC.setBounds(60,5,90,20);
        tfNhaCC.setBounds(60,25,180,30);
        pnNhaCC.setLayout(null);
        pnNhaCC.add(lbNhaCC);   pnNhaCC.add(tfNhaCC);
        
        pnOption.setLayout(null);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(60,25,75,30);
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
        JButton confirmButton = new JButton("OK");
        confirmButton.setBounds(150,25,75,30);
        confirmButton.setBackground(Color.decode("#56c2f5"));
        pnOption.add(cancelButton); pnOption.add(confirmButton);
        cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int choice = JOptionPane.showConfirmDialog(f, "Bạn có chắc muốn hủy?","Cancel",JOptionPane.OK_CANCEL_OPTION);
                if(choice==JOptionPane.OK_OPTION){
                    resetValues();
                }
            }
        });
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
        if(loai.equals("add")){
            confirmButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    // Kiểm tra các điều kiện
                    if(tfMaSP.getText().isEmpty() || tfTenSP.getText().isEmpty() || tfSoLuong.getText().isEmpty() || tfGia.getText().isEmpty() ||
                        cb1.getSelectedItem().equals("Tất cả") || cb2.getSelectedItem().equals("Tất cả") || 
                        cb3.getSelectedItem().equals("Tất cả") || tfNhaCC.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                    } else {
                        // Nếu các điều kiện đều đúng, tiến hành thêm sản phẩm
                        String maSP = tfMaSP.getText();
                        String tenSP = tfTenSP.getText();
                        int soLuong = Integer.parseInt(tfSoLuong.getText());
                        int gia = Integer.parseInt(tfGia.getText());
                        String boXuLy = (String)cb2.getSelectedItem();
                        String boNho = (String)cb3.getSelectedItem();
                        String ram = ((String)cb3.getSelectedItem()).replaceAll("[^0-9]", "");
                        String gpu = tfGPU.getText();
                        String kichThuocMan = tfSize.getText();
                        String nhaCC = tfNhaCC.getText();
            
                        // Tiến hành thêm sản phẩm
                        SanPhamDTO spDTO = new SanPhamDTO();
                        spDTO.setMaMay(maSP);
                        spDTO.setTenMay(tenSP);
                        spDTO.setSoLuong(soLuong);
                        spDTO.setGia(gia);
                        spDTO.setBoXuLy(boXuLy);
                        spDTO.setBoNho(boNho);
                        spDTO.setRam(ram);
                        spDTO.setGPU(gpu);
                        spDTO.setKichthuocman(kichThuocMan);
                        spDTO.setNhaCungCap(nhaCC);
            
                        JOptionPane.showMessageDialog(null, spBUS.addSanPham(spDTO)); // spBUS.addSanPham(spDTO): hiển thị message được định sẵn bên hàm lớp BUS
                    }                
                }
            });
        }
        else if(loai.equals("fix")){
            confirmButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                                        // Kiểm tra các điều kiện
                    if(tfMaSP.getText().isEmpty() || tfTenSP.getText().isEmpty() || tfSoLuong.getText().isEmpty() || tfGia.getText().isEmpty() ||
                        cb1.getSelectedItem().equals("Tất cả") || cb2.getSelectedItem().equals("Tất cả") || 
                        cb3.getSelectedItem().equals("Tất cả") || tfNhaCC.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                    } else {
                        // Nếu các điều kiện đều đúng, tiến hành thêm sản phẩm
                        String maSP = tfMaSP.getText();
                        String tenSP = tfTenSP.getText();
                        int soLuong = Integer.parseInt(tfSoLuong.getText());
                        int gia = Integer.parseInt(tfGia.getText());
                        String boXuLy = (String)cb2.getSelectedItem();
                        String boNho = (String)cb3.getSelectedItem();
                        String ram = ((String)cb3.getSelectedItem()).replaceAll("[^0-9]", "");
                        String gpu = tfGPU.getText();
                        String kichThuocMan = tfSize.getText();
                        String nhaCC = tfNhaCC.getText();
            
                        // Tiến hành thêm sản phẩm
                        SanPhamDTO spDTO = new SanPhamDTO();
                        spDTO.setMaMay(maSP);
                        spDTO.setTenMay(tenSP);
                        spDTO.setSoLuong(soLuong);
                        spDTO.setGia(gia);
                        spDTO.setBoXuLy(boXuLy);
                        spDTO.setBoNho(boNho);
                        spDTO.setRam(ram);
                        spDTO.setGPU(gpu);
                        spDTO.setKichthuocman(kichThuocMan);
                        spDTO.setNhaCungCap(nhaCC);
            
                        JOptionPane.showMessageDialog(null, spBUS.updateSanPham(spDTO)); // spBUS.addSanPham(spDTO): hiển thị message được định sẵn bên hàm lớp BUS
                    }
            }
        });
        }
        f.setResizable(false);
        f.setVisible(true); // Hiển thị JFrame
    }
    
    public void resetValues(){
        //Reset các textfield về chuỗi rỗng
        tfMaSP.setText("");
        tfTenSP.setText("");
        tfSoLuong.setText("");
        tfGia.setText("");
        tfNhaCC.setText("");
        
        //Reset các combobox về lựa chọn "Tất cả"
        cb1.setSelectedIndex(0);    
        cb2.setSelectedIndex(0);
        cb3.setSelectedIndex(0);
        
    }
    
}
