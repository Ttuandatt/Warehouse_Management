/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lop;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import com.formdev.flatlaf.json.ParseException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class PopupNhanVien {
    private JLabel lbmanv, lbtennv, lbngaysinh, lbgioitinh, lbdiachi, lbsdt, lbngayvao, lbloai, lbkho;
    private JTextField tfmanv, tftennv, tfngaysinh, tfdiachi, tfsdt, tfngayvao, tfkho;
    private JComboBox<String> cb1, cb2;
    NhanVienBUS nvBUS = new NhanVienBUS();
    
    public PopupNhanVien(String title, String ban, String loai){
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
        JLabel lb = new JLabel("THÊM NHÂN VIÊN");
        Font font = new Font("Arial", Font.BOLD, 20);
        lb.setFont(font);
        lb.setForeground(Color.WHITE);
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.weightx = 1.0;
        gbcLabel.weighty = 1.0;
        banner.add(lb, gbcLabel);
        
        JPanel pnMa, pnTen, pnNgaySinh, pnGioiTinh, pnDiaChi, pnSdt, pnNgayVao, pnLoai, pnKho, pnOption;
        pnMa = new JPanel();
        pnMa.setBackground(Color.WHITE);
        pnTen = new JPanel();
        pnTen.setBackground(Color.WHITE);
        pnNgaySinh = new JPanel();
        pnNgaySinh.setBackground(Color.WHITE);
        pnGioiTinh = new JPanel();
        pnGioiTinh.setBackground(Color.WHITE);
        pnDiaChi = new JPanel();
        pnDiaChi.setBackground(Color.WHITE);
        pnSdt = new JPanel();
        pnSdt.setBackground(Color.WHITE);
        pnNgayVao = new JPanel();
        pnNgayVao.setBackground(Color.WHITE);
        pnLoai = new JPanel();
        pnLoai.setBackground(Color.WHITE);
        pnKho = new JPanel();
        pnKho.setBackground(Color.WHITE);
        pnOption = new JPanel();
        pnOption.setBackground(Color.WHITE);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(pnMa, gbc);
        gbc.gridy = 1;
        content.add(pnTen, gbc);
        gbc.gridy = 2;
        content.add(pnNgaySinh, gbc);
        gbc.gridy = 3;
        content.add(pnGioiTinh, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        content.add(pnDiaChi, gbc);
        gbc.gridy = 1;
        content.add(pnSdt, gbc);
        gbc.gridy = 2;
        content.add(pnNgayVao, gbc);
        gbc.gridy = 3;
        content.add(pnLoai, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        content.add(pnKho, gbc);
        gbc.gridy = 3;
        content.add(pnOption, gbc);
        
        lbmanv = new JLabel("Mã nhân viên");
        lbtennv = new JLabel("Tên nhân viên");
        lbngaysinh = new JLabel("Ngày sinh");
        lbgioitinh = new JLabel("Giới tính");
        lbdiachi = new JLabel("Địa chỉ");
        lbsdt = new JLabel("SĐT");
        lbngayvao = new JLabel("Ngày vào");
        lbloai = new JLabel("Loại nhân viên");
        lbkho = new JLabel("Kho làm việc");
        
        tfmanv = new JTextField();
        tftennv = new JTextField();
        tfngaysinh = new JTextField();
        tfdiachi = new JTextField();
        tfsdt = new JTextField();
        tfngayvao = new JTextField();
        tfkho = new JTextField();
        
        lbmanv.setBounds(40,5,100,20);
        tfmanv.setBounds(40,25,180,30);
        pnMa.setLayout(null);
        pnMa.add(lbmanv);  pnMa.add(tfmanv);
        
        lbtennv.setBounds(40,5,110,20);
        tftennv.setBounds(40,25,180,30);
        pnTen.setLayout(null);
        pnTen.add(lbtennv);    pnTen.add(tftennv);
        
        lbngaysinh.setBounds(40,5,110,20);
        tfngaysinh.setBounds(40,25,180,30);
        pnNgaySinh.setLayout(null);
        pnNgaySinh.add(lbngaysinh);    pnNgaySinh.add(tfngaysinh);
        
        lbdiachi.setBounds(40,5,110,20);
        tfdiachi.setBounds(40,25,180,30);
        pnDiaChi.setLayout(null);
        pnDiaChi.add(lbdiachi); pnDiaChi.add(tfdiachi);
        
        lbsdt.setBounds(40,5,110,20);
        tfsdt.setBounds(40,25,180,30);
        pnSdt.setLayout(null);
        pnSdt.add(lbsdt);   pnSdt.add(tfsdt);
        
        lbngayvao.setBounds(40,5,110,20);
        tfngayvao.setBounds(40,25,180,30);
        pnNgayVao.setLayout(null);
        pnNgayVao.add(lbngayvao);    pnNgayVao.add(tfngayvao);
        
        lbkho.setBounds(40,5,110,20);
        tfkho.setBounds(40,25,180,30);
        pnKho.setLayout(null);
        pnKho.add(lbkho);    pnKho.add(tfkho);
        
        //Set các combobox
        lbgioitinh.setBounds(40,5,110,20);
        String[] combo1 = {"Tất cả", "Nam", "Nữ"};
        cb1 = new JComboBox<>(combo1);
        cb1.setBounds(40, 25, 110,30);
        pnGioiTinh.setLayout(null);
        pnGioiTinh.add(lbgioitinh); pnGioiTinh.add(cb1);
        
        lbloai.setBounds(40,5,110,20);
        String[] combo2 = {"Tất cả", "0", "1"};
        cb2 = new JComboBox<>(combo2);
        cb2.setBounds(40,25,110,30);
        pnLoai.setLayout(null);
        pnLoai.add(lbloai); pnLoai.add(cb2);
        
        
        pnOption.setLayout(null);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(60,50,75,30);
        cancelButton.setBackground(Color.decode("#E42535"));
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cancelButton.setBackground(Color.decode("#EB5C68"));
                cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                cancelButton.setBackground(Color.decode("#E42535"));
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(f, "Bạn có chắc muốn hủy?", "Cancel", JOptionPane.OK_CANCEL_OPTION);
                if (choice == JOptionPane.OK_OPTION) {
                    resetValues();
                }
            }
        });
        
        JButton confirmButton = new JButton("OK");
        confirmButton.setBounds(150,50,75,30);
        confirmButton.setBackground(Color.decode("#56c2f5"));
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                confirmButton.setBackground(Color.decode("#bde2f2"));
                confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                confirmButton.setBackground(Color.decode("#56c2f5"));
            }
        });
        pnOption.add(cancelButton);
        pnOption.add(confirmButton);
        
        if (loai.equals("add")) {
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Kiểm tra các điều kiện
                    try {
                        if (tfmanv.getText().isEmpty() || tftennv.getText().isEmpty() || 
                            tfngaysinh.getText().isEmpty() || 
                            tfdiachi.getText().isEmpty() || 
                            tfsdt.getText().isEmpty() || 
                            tfngayvao.getText().isEmpty() || 
                            tfkho.getText().isEmpty() ||
                            cb1.getSelectedItem().equals("Tất cả") ||
                            cb2.getSelectedItem().equals("Tất cả")) {
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                        } else if(!isValidDate(tfngaysinh.getText()) || !isValidDate(tfngayvao.getText())){
                            JOptionPane.showMessageDialog(null, "Thời gian không hợp lệ");
                        }
                        else {
                            // Chuyển đổi ngày vào làm và ngày sinh thành đối tượng LocalDate
                            LocalDate ngaySinh = LocalDate.parse(tfngaysinh.getText(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
                            LocalDate ngayVao = LocalDate.parse(tfngayvao.getText(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
                            Date ngaySinhDate = Date.valueOf(ngaySinh);
                            Date ngayVaoDate = Date.valueOf(ngayVao);
                            // Kiểm tra tuổi của nhân viên
                            LocalDate ngayHienTai = LocalDate.now();
                            int tuoi = Period.between(ngaySinh, ngayHienTai).getYears();
                
                            if (tuoi < 18 || ngayVao.minusYears(18).isBefore(ngaySinh)) {
                                JOptionPane.showMessageDialog(null, "Nhân viên phải đủ 18 tuổi trở lên để được vào làm.");
                                return;
                            }

                            String manv = tfmanv.getText();
                            String tennv = tftennv.getText();
                            String ngaysinh = tfngaysinh.getText();
                            String gioitinh = (String) cb1.getSelectedItem();
                            String diachi = tfdiachi.getText();
                            String sdt = tfsdt.getText();
                            String ngayvao = tfngayvao.getText();
                            int loai = Integer.parseInt((String) cb2.getSelectedItem());
                            String kho = tfkho.getText();


                            NhanVienDTO nvDTO = new NhanVienDTO();
                            nvDTO.setManv(manv);
                            nvDTO.setTennv(tennv);
                            nvDTO.setNgaysinh(ngaysinh);
                            nvDTO.setGioitinh(gioitinh);
                            nvDTO.setDiachi(diachi);
                            nvDTO.setSdt(sdt);
                            nvDTO.setNgayvao(ngayvao);
                            nvDTO.setLoai(loai);
                            nvDTO.setKho(kho);

                            JOptionPane.showMessageDialog(null, nvBUS.addNhanVien(nvDTO)); // nvBUS.addNhanVien(nvDTO): hiển thị message được định sẵn bên hàm lớp BUS
                        }
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
                    } 
                }
            });

        } else if (loai.equals("fix")) {
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Kiểm tra các điều kiện
                    try {
                        if (tfmanv.getText().isEmpty() || tftennv.getText().isEmpty() || 
                            tfngaysinh.getText().isEmpty() || 
                            tfdiachi.getText().isEmpty() || 
                            tfsdt.getText().isEmpty() || 
                            tfngayvao.getText().isEmpty() || 
                            tfkho.getText().isEmpty() ||
                            cb1.getSelectedItem().equals("Tất cả") ||
                            cb2.getSelectedItem().equals("Tất cả")) {
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                        } else if(!isValidDate(tfngaysinh.getText()) || !isValidDate(tfngayvao.getText())){
                            JOptionPane.showMessageDialog(null, "Thời gian không hợp lệ");
                        }
                        else {
                            // Chuyển đổi ngày vào làm và ngày sinh thành đối tượng LocalDate
                            LocalDate ngaySinh = LocalDate.parse(tfngaysinh.getText(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
                            LocalDate ngayVao = LocalDate.parse(tfngayvao.getText(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
                            Date ngaySinhDate = Date.valueOf(ngaySinh);
                            Date ngayVaoDate = Date.valueOf(ngayVao);
                            // Kiểm tra tuổi của nhân viên
                            LocalDate ngayHienTai = LocalDate.now();
                            int tuoi = Period.between(ngaySinh, ngayHienTai).getYears();
                
                            if (tuoi < 18 || ngayVao.minusYears(18).isBefore(ngaySinh)) {
                                JOptionPane.showMessageDialog(null, "Nhân viên phải đủ 18 tuổi trở lên để được vào làm.");
                                return;
                            }

                            String manv = tfmanv.getText();
                            String tennv = tftennv.getText();
                            String ngaysinh = tfngaysinh.getText();
                            String gioitinh = (String) cb1.getSelectedItem();
                            String diachi = tfdiachi.getText();
                            String sdt = tfsdt.getText();
                            String ngayvao = tfngayvao.getText();
                            int loai = Integer.parseInt((String) cb2.getSelectedItem());
                            String kho = tfkho.getText();

                            // Kiểm tra định dạng của số điện thoại
                            if (!isValidPhoneNumber(sdt)) {
                                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                                return;
                            }

                            NhanVienDTO nvDTO = new NhanVienDTO();
                            nvDTO.setManv(manv);
                            nvDTO.setTennv(tennv);
                            nvDTO.setNgaysinh(ngaysinh);
                            nvDTO.setGioitinh(gioitinh);
                            nvDTO.setDiachi(diachi);
                            nvDTO.setSdt(sdt);
                            nvDTO.setNgayvao(ngayvao);
                            nvDTO.setLoai(loai);
                            nvDTO.setKho(kho);

                            JOptionPane.showMessageDialog(null, nvBUS.updateNhanVien(nvDTO)); // nvBUS.addNhanVien(nvDTO): hiển thị message được định sẵn bên hàm lớp BUS
                        }
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
                    } 
                }
            });
        }
        
        f.setSize(800,500);
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

    public boolean isValidDate(String dateStr) {
        // Kiểm tra xem chuỗi ngày có đúng định dạng dd/MM/yyyy không
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            // Thử chuyển đổi chuỗi thành đối tượng Date
            sdf.parse(dateStr);
            // Kiểm tra chuỗi ngày có đúng độ dài 10 ký tự hay không
            if (dateStr.length() != 10) {
                return false;
            }

            // Nếu chuyển đổi thành công, ngày hợp lệ
            return true;
        } catch (java.text.ParseException e) {
            // Nếu có lỗi xảy ra trong quá trình chuyển đổi, ngày không hợp lệ
            return false;
        }
    }

    private void resetValues() {
        tfmanv.setText("");
        tftennv.setText("");
        tfngaysinh.setText("");
        tfdiachi.setText("");
        tfsdt.setText("");
        tfngayvao.setText("");
        tfkho.setText("");
        
        cb1.setSelectedIndex(0);
        cb2.setSelectedIndex(0);
    }
}
