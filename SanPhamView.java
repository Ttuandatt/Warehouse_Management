package View;

import Lop.SanPham;
import Lop.TableCustom1;
import Model.SanPhamDAO;
import Model.SanPhamTableModel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.ImageIcon;
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
    JTable table;
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
        table = new JTable(model);   //Tạo 1 bảng truyền với đối số truyền vào là model
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
        JPanel panelXemChiTiet = new JPanel();
        panelThem.setBackground(Color.GRAY);
        panelXoa.setBackground(Color.CYAN);
        panelSua.setBackground(Color.ORANGE);
        panelXuatExcel.setBackground(Color.PINK);
        panelXemChiTiet.setBackground(Color.BLUE);
        
        panelThem.setBounds(20, 20, 50, 60);
        panelThem.setLayout(null);
        panelXoa.setBounds(70,20,50,60);
        panelXoa.setLayout(null);
        panelSua.setBounds(120,20,50,60);
        panelSua.setLayout(null);
        panelXemChiTiet.setBounds(170,20,80,60);
        panelXemChiTiet.setLayout(null);
        panelXuatExcel.setBounds(270,20,80,60);
        panelXuatExcel.setLayout(null);
        
        
        leftFunction.add(panelThem);
        leftFunction.add(panelXoa);
        leftFunction.add(panelSua);
        leftFunction.add(panelXemChiTiet);
        leftFunction.add(panelXuatExcel);
        
        
        
        //Thêm các nút chức năng vào các panel ở leftFunction
        JButton buttonThem, buttonXoa, buttonSua, buttonXemChiTiet, buttonXuatExcel;
        
        buttonThem = new JButton();
        buttonThem.setBackground(Color.WHITE);
        ImageIcon iconAdd = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\plus8.png");
        Image img = iconAdd.getImage().getScaledInstance(33, 33, java.awt.Image.SCALE_SMOOTH);  //Chỉnh sửa kích thước ảnh
        iconAdd = new ImageIcon(img);       //Tạo lại iconAdd bằng ảnh vừa được chỉnh sửa kích thước
        
        JLabel lbThem = new JLabel("Thêm", JLabel.CENTER);
        lbThem.setVerticalAlignment(JLabel.BOTTOM);
        
        JPanel panelButtonThem = new JPanel();
        panelButtonThem.setLayout(new BorderLayout());
        panelButtonThem.setBackground(Color.WHITE);
        panelButtonThem.setBounds(0,0,50,60);
        panelButtonThem.add(new JLabel(iconAdd), BorderLayout.CENTER);  //Add ảnh vào vị trí giữa button
        panelButtonThem.add(lbThem, BorderLayout.SOUTH);    //Add label "Thêm" vào bottom của button
        
        buttonThem.setLayout(null);
        buttonThem.setBounds(0,0,50,60);
        buttonThem.add(panelButtonThem);
        buttonThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableCustom1 tableThem = new TableCustom1("Thêm sản phẩm", "THÊM SẢN PHẨM");
            }
        });
        buttonThem.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonThem.setBackground(Color.decode("#D6D6D6")); // Đổi màu khi hover vào
                buttonThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonThem.setBackground(Color.decode("#D6D6D6"));
                
            }
    
            @Override
            public void mouseExited(MouseEvent e){
                buttonThem.setBackground(Color.WHITE); // Quy lại màu bình thường khi hover ra
                panelButtonThem.setBackground(Color.WHITE);
            }
        });
        
        buttonXoa = new JButton();
        buttonXoa.setBackground(Color.WHITE);
        ImageIcon iconDelete = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\trashcan.png");
        Image img2 = iconDelete.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
        iconDelete = new ImageIcon(img2);
        
        JLabel lbXoa = new JLabel("Xóa", JLabel.CENTER);
        lbXoa.setVerticalAlignment(JLabel.BOTTOM);
        
        JPanel panelButtonXoa = new JPanel();
        panelButtonXoa.setLayout(new BorderLayout());
        panelButtonXoa.setBackground(Color.WHITE);
        panelButtonXoa.setBounds(0,0,50,60);
        panelButtonXoa.add(new JLabel(iconDelete), BorderLayout.CENTER);
        panelButtonXoa.add(lbXoa, BorderLayout.SOUTH);
        
        buttonXoa.setLayout(null);
        buttonXoa.setBounds(0,0,50,60);
        buttonXoa.add(panelButtonXoa);
        buttonXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                xoaPerformed(table);
            }
        });
        buttonXoa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonXoa.setBackground(Color.decode("#D6D6D6")); // Đổi màu khi hover vào
                buttonXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonXoa.setBackground(Color.decode("#D6D6D6"));
                
            }
    
            @Override
            public void mouseExited(MouseEvent e){
                buttonXoa.setBackground(Color.WHITE); // Quy lại màu bình thường khi hover ra
                panelButtonXoa.setBackground(Color.WHITE);
            }
        });
        
        buttonSua = new JButton();
        buttonSua.setBackground(Color.WHITE);
        ImageIcon iconFix = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\pencil.png");
        Image img3 = iconFix.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconFix = new ImageIcon(img3);
        
        JLabel lbSua = new JLabel("Sửa", JLabel.CENTER);
        lbSua.setVerticalAlignment(JLabel.BOTTOM);
        
        JPanel panelButtonSua = new JPanel();
        panelButtonSua.setLayout(new BorderLayout());
        panelButtonSua.setBackground(Color.WHITE);
        panelButtonSua.setBounds(0,0,50,60);
        panelButtonSua.add(new JLabel(iconFix), BorderLayout.CENTER);
        panelButtonSua.add(lbSua, BorderLayout.SOUTH);
        
        buttonSua.setLayout(null);
        buttonSua.setBounds(0,0,50,60);
        buttonSua.add(panelButtonSua);
        buttonSua.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                suaPerformed(table);
            }
        });
        buttonSua.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonSua.setBackground(Color.decode("#D6D6D6"));
                buttonSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonSua.setBackground(Color.decode("#D6D6D6"));
                
            }
            @Override
            public void mouseExited(MouseEvent e){
                buttonSua.setBackground(Color.WHITE);
                panelButtonSua.setBackground(Color.WHITE);
            }
        });
        
        buttonXemChiTiet = new JButton();
        buttonXemChiTiet.setBackground(Color.WHITE);
        ImageIcon iconSee = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\eye2.jpg");
        Image img4 = iconSee.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
        iconSee = new ImageIcon(img4);
        
        JLabel lbXem = new JLabel("Xem chi tiết", JLabel.CENTER);
        lbXem.setVerticalAlignment(JLabel.BOTTOM);
        
        JPanel panelButtonXem = new JPanel();
        panelButtonXem.setLayout(new BorderLayout());
        panelButtonXem.setBackground(Color.WHITE);
        panelButtonXem.setBounds(0,0,80,60);
        panelButtonXem.add(new JLabel(iconSee), BorderLayout.CENTER);
        panelButtonXem.add(lbXem, BorderLayout.SOUTH);
        
        buttonXemChiTiet.setLayout(null);
        buttonXemChiTiet.setBounds(0,0,80,60);
        buttonXemChiTiet.add(panelButtonXem);
        buttonXemChiTiet.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        buttonXemChiTiet.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonXemChiTiet.setBackground(Color.decode("#D6D6D6"));
                buttonXemChiTiet.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonXem.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                buttonXemChiTiet.setBackground(Color.WHITE);
                panelButtonXem.setBackground(Color.WHITE);
            }
        });
        
        buttonXuatExcel = new JButton();
        buttonXuatExcel.setBackground(Color.WHITE);
        ImageIcon iconXuat = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\excel1.png");
        Image img5 = iconXuat.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
        iconSee = new ImageIcon(img5);
        
        JLabel lbXuat = new JLabel("Xuất Excel", JLabel.CENTER);
        lbXuat.setVerticalAlignment(JLabel.BOTTOM);
        
        JPanel panelButtonXuat = new JPanel();
        panelButtonXuat.setLayout(new BorderLayout());
        panelButtonXuat.setBackground(Color.WHITE);
        panelButtonXuat.setBounds(0,0,80,60);
        panelButtonXuat.add(new JLabel(iconSee), BorderLayout.CENTER);
        panelButtonXuat.add(lbXuat, BorderLayout.SOUTH);
        
        buttonXuatExcel.setLayout(null);
        buttonXuatExcel.setBounds(0,0,80,60);
        buttonXuatExcel.add(panelButtonXuat);
        buttonXuatExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        buttonXuatExcel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonXuatExcel.setBackground(Color.decode("#D6D6D6"));
                buttonXuatExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonXuat.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                buttonXuatExcel.setBackground(Color.WHITE);
                panelButtonXuat.setBackground(Color.WHITE);
            }
        });
        
        panelThem.add(buttonThem);
        panelXoa.add(buttonXoa);
        panelSua.add(buttonSua);
        panelXemChiTiet.add(buttonXemChiTiet);
        panelXuatExcel.add(buttonXuatExcel);
        
        //Thêm các label mô tả các nút chức năng
//        JLabel labelThem, labelXoa, labelSua, labelXuatExcel;
//        labelThem = new JLabel("    Thêm");
//        labelThem.setBounds(0,40,80,20);
//        labelXoa = new JLabel("      Xóa");
//        labelXoa.setBounds(0,40,80,20);
//        labelSua = new JLabel("   Sửa");
//        labelSua.setBounds(8,40,80,20);
//        labelXuatExcel = new JLabel("   Xuất Excel");
//        labelXuatExcel.setBounds(-5,40,80,20);
//        
//        panelThem.add(labelThem);
//        panelXoa.add(labelXoa);
//        panelSua.add(labelSua);
//        panelXuatExcel.add(labelXuatExcel);
        
        
        
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
        tf.setBounds(10,20,210,30);
        JButton search = new JButton("Tìm kiếm");
        search.setBounds(240,20,90,30);
        panelSearchbox.add(tf); panelSearchbox.add(search);
        //Tạo nút Làm mới để reset tìm kiếm
        JButton buttonLamMoi = new JButton("Làm mới");
        buttonLamMoi.setBounds(10,20,100,30);
        buttonLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SanPhamDAO sp = new SanPhamDAO();
                List<SanPham> updatedData = sp.getAllSanPham();
                SanPhamTableModel updatedModel = new SanPhamTableModel(updatedData);
                table.setModel(updatedModel);
            }
        });
        panelLamMoi.add(buttonLamMoi);
        
        
        
       
    }
    
    private void xoaPerformed(JTable tb){
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) { // -1 nếu không có dòng nào được chọn
            int modelRow = table.convertRowIndexToModel(selectedRow); // Chuyển đổi chỉ mục dòng từ view sang model
            SanPhamTableModel model = (SanPhamTableModel) table.getModel();
            model.removeRow(modelRow); // Xóa dòng khỏi dữ liệu trong model
            model.fireTableDataChanged(); // Cập nhật lại bảng
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void suaPerformed(JTable tb){
        int selectedRow = table.getSelectedRow();
        if(selectedRow != -1){
            TableCustom1 tableSua = new TableCustom1("Sửa sản phẩm", "SỬA SẢN PHẨM");
             
        }
        else{
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
}
