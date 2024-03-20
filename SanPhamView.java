package View;

import Lop.SanPham;
import Model.SanPhamDAO;
import Model.SanPhamTableModel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class SanPhamView extends JPanel {
    private JPanel content1;
    private JLabel lbMaSP, lbTenSP, lbSoLuong,lbGia,lbBoXuLy,lbBoNho,lbRam,lbNhaCC;
    private JTextField tfMaSP, tfTenSP, tfSoLuong,tfGia;
    private JComboBox<String> cb2;
    private JComboBox<String> cb3;
    private JComboBox<String> cb4;
    private JComboBox<String> cb5;
    //Constructor
    public SanPhamView(){
        giaoDienSanPham();
    }
    
    //////////////////////////////////////////METHODS//////////////////////////////////////
    private void giaoDienSanPham(){
        setLayout(new FlowLayout());
        setBackground(Color.decode("#6c757d")); 
        setLayout(new GridBagLayout());
        
        JPanel functionBar = new JPanel();
        functionBar.setBackground(Color.YELLOW);
        functionBar.setLayout(new GridBagLayout());
        functionBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5)); //Để cái functionBar nó cách viền 5px ở các cạnh, riêng bottom thì cách 10px
        content1 = new JPanel();
        content1.setBackground(Color.WHITE);
        content1.setLayout(new GridBagLayout());
        content1.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5)); //Để cái content nó cách viền 5px ở các cạnh, riêng canh top thì cách 10px
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(functionBar, gbc);
        gbc.weighty = 0.8;
        gbc.gridy = 1;
        add(content1, gbc);
        
        //Tạo 2 panel trái, phải chứa các chức năng
        JPanel leftFunction = new JPanel();
        leftFunction.setBackground(Color.RED);
        leftFunction.setBorder(BorderFactory.createTitledBorder("Chức năng"));
        JPanel rightFunction = new JPanel();
        rightFunction.setBackground(Color.BLUE);
        rightFunction.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        functionBar.add(leftFunction, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.6;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        functionBar.add(rightFunction, gbc);
        
        // Load dữ liệu từ cơ sở dữ liệu và cập nhật JTable
        SanPhamDAO sanPhamDAO = new SanPhamDAO();   //Tạo 1 đối tượng sanPhamDAO thuộc lớp SanPhamDAO
        List<SanPham> data = sanPhamDAO.getAllSanPham();    //sanPhamDAO có method getAllSanPham() trả về 1 ArrayList chứa các đối tượng thuộc lớp SanPham. Truyền các đổi tượng lấy được qua method getAllSanPham vào List data
        SanPhamTableModel model = new SanPhamTableModel(data);  //Khởi tạo 1 đối tượng model thuộc lớp SanPhamTableModel với tham số truyền vào là 1 List<SanPham>, đối số hiện được truyền vào là List<SanPham> data vừa được khai báo phía trên
        JTable table = new JTable(model);   //Tạo 1 bảng truyền với đối số truyền vào là model
        JScrollPane sp = new JScrollPane(table);
        // Tùy chỉnh giao diện của thanh cuộn dọc
        JScrollBar verticalScrollBar = sp.getVerticalScrollBar();
        verticalScrollBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.decode("#BED5DA"); // Màu của thanh cuộn
                this.trackColor = Color.decode("#f8f9fa"); // Màu của vùng chứa thanh cuộn
            }
        });
        
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        content1.add(sp, gbc);
        
        leftFunction.setLayout(null);
        rightFunction.setLayout(new GridBagLayout());
        
        //Tạo và thêm các panel chứa các nút chức năng ở leftFunction
        JPanel panelThem = new JPanel();
        JPanel panelXoa = new JPanel();
        JPanel panelSua = new JPanel();
        JPanel panelXuatExcel = new JPanel();
        panelThem.setBackground(Color.GRAY);
        panelXoa.setBackground(Color.CYAN);
        panelSua.setBackground(Color.ORANGE);
        panelXuatExcel.setBackground(Color.PINK);
        
        panelThem.setBounds(20, 20, 60, 60);
        panelThem.setLayout(null);
        panelXoa.setBounds(90,20,60,60);
        panelXoa.setLayout(null);
        panelSua.setBounds(160,20,60,60);
        panelSua.setLayout(null);
        panelXuatExcel.setBounds(260,20,70,60);
        panelXuatExcel.setLayout(null);
        
        
        leftFunction.add(panelThem);
        leftFunction.add(panelXoa);
        leftFunction.add(panelSua);
        leftFunction.add(panelXuatExcel);
        
        
        //Thêm các nút chức năng vào các panel ở leftFunction
        JButton buttonThem, buttonXoa, buttonSua, buttonXuatExcel;
        buttonThem = new JButton("+");
        buttonThem.setBounds(0,0,60,40);
        buttonXoa = new JButton("-");
        buttonXoa.setBounds(0,0,60,40);
        buttonSua = new JButton("Sửa");
        buttonSua.setBounds(0,0,60,40);
        buttonXuatExcel = new JButton("Xuất Excel");
        buttonXuatExcel.setBounds(0,0,70,40);
        
        panelThem.add(buttonThem);
        panelXoa.add(buttonXoa);
        panelSua.add(buttonSua);
        panelXuatExcel.add(buttonXuatExcel);
        
        //Thêm các label mô tả các nút chức năng
        JLabel labelThem, labelXoa, labelSua, labelXuatExcel;
        labelThem = new JLabel("    Thêm");
        labelThem.setBounds(0,40,80,20);
        labelXoa = new JLabel("      Xóa");
        labelXoa.setBounds(0,40,80,20);
        labelSua = new JLabel("   Sửa");
        labelSua.setBounds(8,40,80,20);
        labelXuatExcel = new JLabel("   Xuất Excel");
        labelXuatExcel.setBounds(-5,40,80,20);
        
        panelThem.add(labelThem);
        panelXoa.add(labelXoa);
        panelSua.add(labelSua);
        panelXuatExcel.add(labelXuatExcel);
        
        
        
        //Tạo và thêm các panel chứa các chức năng tìm kiếm
        JPanel panelCombobox = new JPanel();
        JPanel panelSearchbox = new JPanel();
        JPanel panelLamMoi = new JPanel();
        panelCombobox.setBackground(Color.LIGHT_GRAY);
        panelCombobox.setLayout(null);
        panelSearchbox.setBackground(Color.MAGENTA);    
        panelSearchbox.setLayout(null);
        panelLamMoi.setBackground(Color.WHITE);
        panelLamMoi.setLayout(null);
        
        gbc = new GridBagConstraints(); // Resetting GridBagConstraints

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 0.3;
        gbc.fill = GridBagConstraints.BOTH; 
        rightFunction.add(panelCombobox, gbc);
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.gridx = 1;
        rightFunction.add(panelSearchbox, gbc);
        gbc.weightx = 0.2;
        gbc.weighty = 0.2;
        gbc.gridx = 2;
        rightFunction.add(panelLamMoi, gbc);
        
        
        //Tạo combobox
        String combo[] = {"Tất cả", "Giá tăng dần", "Giá giảm dần"};
        JComboBox cb = new JComboBox(combo);
        cb.setBounds(10,20,120,30);
        panelCombobox.add(cb);
        //Tạo textfield để nhập tìm kiếm
        JTextField tf = new JTextField();
        tf.setBounds(10,20,257,30);
        panelSearchbox.add(tf);
        //Tạo nút Làm mới để reset tìm kiếm
        JButton buttonLamMoi = new JButton("Làm mới");
        buttonLamMoi.setBounds(10,20,100,30);
        panelLamMoi.add(buttonLamMoi);
        
        //Tạo sự kiện cho các nút
        buttonThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableThem(e);
            }
        });
       
    }
    
    //Các table chức năng
    private void tableThem(ActionEvent e) {
        JFrame f = new JFrame("Thêm sản phẩm");

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
        JLabel lb = new JLabel("THÊM SẢN PHẨM");
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
    
        JButton addButton = new JButton("OK");
        addButton.setBounds(12,20,100,30);
        pnAdd.setLayout(null);
        pnAdd.add(addButton);
    
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
