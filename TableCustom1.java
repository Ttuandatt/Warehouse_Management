/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lop;

import Model.SanPhamDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class TableCustom1 extends JTable {
    private JLabel lbMaSP, lbTenSP, lbSoLuong,lbGia,lbBoXuLy,lbBoNho,lbRam,lbNhaCC;
    private JTextField tfMaSP, tfTenSP, tfSoLuong,tfGia;
    private JComboBox<String> cb2;
    private JComboBox<String> cb3;
    private JComboBox<String> cb4;
    private JComboBox<String> cb5;
    public TableCustom1(String title, String ban){  //ban: banner viết tắt nhưng vì trùng với JPanel bên dưới nên để là ban
        JFrame f = new JFrame(title);

        f.setLayout(new GridBagLayout());
        f.setSize(500, 400);

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
        JPanel pnMa, pnTen, pnSoluong, pnGia, pnBoXuLy, pnBoNho,pnRam,pnNhaCC, pnCancel, pnAdd;
    
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
        pnNhaCC = new JPanel();
        pnNhaCC.setBackground(Color.WHITE);
        pnCancel = new JPanel();
        pnCancel.setBackground(Color.WHITE);
        pnAdd = new JPanel();
        pnAdd.setBackground(Color.WHITE);
    
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
        gbc.gridy = 4;
        content.add(pnCancel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        content.add(pnBoXuLy, gbc);
        gbc.gridy  = 1;
        content.add(pnBoNho, gbc);
        gbc.gridy = 2;
        content.add(pnRam, gbc);
        gbc.gridy = 3;
        content.add(pnNhaCC, gbc);
        gbc.gridy = 4;
        content.add(pnAdd, gbc);
            
        //Tạo và thêm các label, textfield, combobox
        lbMaSP = new JLabel("Mã sản phẩm");
        lbTenSP =  new JLabel("Tên sản phẩm");
        lbSoLuong = new JLabel("Số lượng");
        lbGia = new JLabel("Giá");
        lbBoXuLy = new JLabel("Bộ xử lý");
        lbBoNho = new JLabel("Bộ nhớ");
        lbRam = new JLabel("RAM");
        lbNhaCC = new JLabel("Nhà cung cấp");
        
        tfMaSP = new JTextField();
        tfTenSP = new JTextField();
        tfSoLuong = new JTextField();
        tfGia = new JTextField();
    
        lbMaSP.setBounds(10,5,90,20);
        tfMaSP.setBounds(10,25,160,20);
        pnMa.setLayout(null);
        pnMa.add(lbMaSP);   pnMa.add(tfMaSP);
    
        lbTenSP.setBounds(10,5,90,20);
        tfTenSP.setBounds(10,25,160,20);
        pnTen.setLayout(null);
        pnTen.add(lbTenSP); pnTen.add(tfTenSP);
    
        lbSoLuong.setBounds(10,5,90,20);
        tfSoLuong.setBounds(10,25,160,20);
        pnSoluong.setLayout(null);
        pnSoluong.add(lbSoLuong); pnSoluong.add(tfSoLuong);
    
        lbGia.setBounds(10,5,90,20);
        tfGia.setBounds(10,25,160,20);
        pnGia.setLayout(null);
        pnGia.add(lbGia); pnGia.add(tfGia);
    
        JButton cancelButton = new JButton("Cancel");
        pnCancel.setLayout(null);
        cancelButton.setBounds(130,20,100,30);
        pnCancel.add(cancelButton);
        
        //Set các combobox
        lbBoXuLy.setBounds(70,5,90,20);
        String[] combo2 = {"Tất cả","Intel Xeon","Intel Core i5","Intel Core i7", "Intel Core i9", "AMD Ryzen 5", "AMD Ryzen 7", "Apple M1 Chip"};
        cb2 = new JComboBox(combo2);
        cb2.setBounds(70,25,120,20);
        pnBoXuLy.setLayout(null);
        pnBoXuLy.add(lbBoXuLy); pnBoXuLy.add(cb2);
    
        lbBoNho.setBounds(70,5,90,20);
        String[] combo3 = {"Tất cả","256GB","512GB"};
        cb3 = new JComboBox(combo3);
        cb3.setBounds(70,25,120,20);
        pnBoNho.setLayout(null);
        pnBoNho.add(lbBoNho);   pnBoNho.add(cb3);
    
        lbRam.setBounds(70,5,90,20);
        String[] combo4 = {"Tất cả", "8GB", "16GB", "32GB"};
        cb4 = new JComboBox(combo4);
        cb4.setBounds(70,25,120,20);
        pnRam.setLayout(null);
        pnRam.add(lbRam);   pnRam.add(cb4);
    
        lbNhaCC.setBounds(70,5,90,20);
        String[] combo5 = {"Tất cả", "NCC2134","NCC2135","NCC2136","NCC2137"};
        cb5 = new JComboBox(combo5);
        cb5.setBounds(70,25,120,20);
        pnNhaCC.setLayout(null);
        pnNhaCC.add(lbNhaCC);   pnNhaCC.add(cb5);
    
        JButton confirmButton = new JButton("OK");
        confirmButton.setBounds(12,20,100,30);
        pnAdd.setLayout(null);
        pnAdd.add(confirmButton);
    
        //Xử lý sự kiện cho button Cancel & OK
        cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int choice = JOptionPane.showConfirmDialog(f, "Bạn có chắc muốn hủy?","Cancel",JOptionPane.OK_CANCEL_OPTION);
                if(choice==JOptionPane.OK_OPTION){
                    resetValues();
                }
            }
        });
        confirmButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String maSP = tfMaSP.getText();
                String tenSP = tfTenSP.getText();
                int soLuong = Integer.parseInt(tfSoLuong.getText());
                int gia = Integer.parseInt(tfGia.getText());
                String boXuLy = (String)cb2.getSelectedItem();
                String boNho = (String)cb3.getSelectedItem();
                int ram = Integer.parseInt(((String)cb4.getSelectedItem()).replaceAll("[^0-9]", ""));
                String nhaCC = (String)cb5.getSelectedItem();

        
                SanPhamDAO sanPhamDAO = new SanPhamDAO();
                sanPhamDAO.addSanPham(maSP, tenSP, soLuong, gia, boXuLy, boNho, ram, nhaCC);    //Thêm 1 sản phẩm
//                List<SanPham> updatedData = sanPhamDAO.getAllSanPham(); //update lại dữ liệu
//                SanPhamTableModel updatedModel = new SanPhamTableModel(updatedData);    //Tạo 1 model TableModel mới và truyền vào dữ liệu vừa được update
//                table.setModel(updatedModel);   //Set model
            }
        });
        
        
        f.setResizable(false);
        f.setVisible(true); // Hiển thị JFrame
    }
    
    public void resetValues(){
        //Reset các textfield về chuỗi rỗng
        tfMaSP.setText("");
        tfTenSP.setText("");
        tfSoLuong.setText("");
        tfGia.setText("");
        
        //Reset các combobox về lựa chọn "Tất cả"
        cb2.setSelectedIndex(0);    
        cb3.setSelectedIndex(0);
        cb4.setSelectedIndex(0);
        cb5.setSelectedIndex(0);
        
    }
}
