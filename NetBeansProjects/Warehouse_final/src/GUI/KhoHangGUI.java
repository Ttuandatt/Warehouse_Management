/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.KhoHangDTO;
import DTO.SanPhamDTO;
import BUS.KhoHangBUS;
import BUS.SanPhamBUS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import Lop.PopupKhoHang;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

public class KhoHangGUI extends JPanel{
    KhoHangBUS khoBUS = new KhoHangBUS();
    SanPhamBUS spBUS = new SanPhamBUS();
    JTable tableKho = new JTable();
    JTable tableSanPham = new JTable();
    DefaultTableModel modelKho = new DefaultTableModel();
    DefaultTableModel modelSanPham = new DefaultTableModel();
    ArrayList<KhoHangDTO> arrKhoHang = new ArrayList<>();
    ArrayList<SanPhamDTO> arrSanPham = new ArrayList<>();
    private JPanel content1;
    private JTextField tfTimKiem;
    private JComboBox cb;
    
    public KhoHangGUI(){
        initComponents();
        loadKhoHangList();
        loadSanPhamList();
          tableKho.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tableKho.getSelectedRow();
                    if (selectedRow != -1) {
                        String selectedMaKho = (String) modelKho.getValueAt(selectedRow, 0);
                        loadProductsByWarehouse(selectedMaKho);
                    }
                }
            }
        });
    }
      private void loadProductsByWarehouse(String maKho) {
        modelSanPham.setRowCount(0);
        ArrayList<SanPhamDTO> products = spBUS.getProductsByWarehouse(maKho);
        for (SanPhamDTO product : products) {
            Object[] row = {product.getMaMay(), product.getTenMay(), product.getSoLuong()};
            modelSanPham.addRow(row);
        }
    }
    
    private void initComponents(){
        tableKho.setDefaultEditor(Object.class, null);
        tableSanPham.setDefaultEditor(Object.class, null);
        setBackground(Color.decode("#6c757d")); 
        setLayout(new GridBagLayout());
        
        JPanel functionBar = new JPanel();
        functionBar.setBackground(Color.WHITE);
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
        
        content1.setLayout(new GridBagLayout());
        JPanel listKho, listSanPham;
        listKho = new JPanel();
        listKho.setBackground(Color.WHITE);
        listKho.setLayout(new GridBagLayout());
        listSanPham = new JPanel();
        listSanPham.setBackground(Color.WHITE);
        
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        content1.add(listKho, gbc);
        gbc.gridx = 1;
        content1.add(listSanPham, gbc);
        
        listKho.setLayout(new GridBagLayout());
        JPanel bannerListKho, tableListKho;
        bannerListKho= new JPanel();
        bannerListKho.setBackground(Color.WHITE);
        tableListKho = new JPanel();
        tableListKho.setBackground(Color.WHITE);
        tableListKho.setLayout(new GridBagLayout());
        gbc.weightx = 1.0;
        gbc.weighty = 0.25;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        listKho.add(bannerListKho, gbc);
        gbc.weighty = 0.75;
        gbc.gridy = 1;
        listKho.add(tableListKho, gbc);
        JLabel lbListKho = new JLabel("Danh sách các kho đang hoạt động");
        Font lbFont = new Font("Arial", Font.BOLD, 25);
        lbListKho.setFont(lbFont);
        lbListKho.setForeground(Color.BLACK);
        bannerListKho.setLayout(new BorderLayout());
        bannerListKho.add(lbListKho, BorderLayout.CENTER);
        
        
        listSanPham.setLayout(new GridBagLayout());
        JPanel bannerListSanPham, tableListSanPham;
        bannerListSanPham= new JPanel();
        bannerListSanPham.setBackground(Color.WHITE);
        tableListSanPham = new JPanel();
        tableListSanPham.setBackground(Color.WHITE);
        tableListSanPham.setLayout(new GridBagLayout());
        gbc.weightx = 1.0;
        gbc.weighty = 0.25;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        listSanPham.add(bannerListSanPham, gbc);
        gbc.weighty = 0.75;
        gbc.gridy = 1;
        listSanPham.add(tableListSanPham, gbc);
        
        JScrollPane spkho = new JScrollPane(tableKho);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        tableListKho.add(spkho, gbc);
        
        JScrollPane spsanpham = new JScrollPane(tableSanPham);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        tableListSanPham.add(spsanpham, gbc);
        
        JLabel lbListSanPham = new JLabel("Danh sách sản phẩm đang có trong kho");
        lbListSanPham.setFont(lbFont);
        lbListSanPham.setForeground(Color.BLACK);
        bannerListSanPham.setLayout(new BorderLayout());
        bannerListSanPham.add(lbListSanPham, BorderLayout.CENTER);
        
        //Tạo 2 panel trái, phải chứa các chức năng
        JPanel leftFunction = new JPanel();
        leftFunction.setBackground(Color.WHITE);
        leftFunction.setBorder(BorderFactory.createTitledBorder("Chức năng"));
        JPanel rightFunction = new JPanel();
        rightFunction.setBackground(Color.WHITE);
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
        panelXuatExcel.setBackground(Color.WHITE);
        panelXemChiTiet.setBackground(Color.WHITE);
        
        panelThem.setBounds(20, 15, 50, 60);
        panelThem.setLayout(null);
        panelXoa.setBounds(70,15,50,60);
        panelXoa.setLayout(null);
        panelSua.setBounds(120,15,50,60);
        panelSua.setLayout(null);
        panelXemChiTiet.setBounds(170,15,80,60);
        panelXemChiTiet.setLayout(null);
        panelXuatExcel.setBounds(270,15,80,60);
        panelXuatExcel.setLayout(null);
        
        
        leftFunction.add(panelThem);
        leftFunction.add(panelXoa);
        leftFunction.add(panelSua);
        leftFunction.add(panelXemChiTiet);
        leftFunction.add(panelXuatExcel);
        
        
        
        //Thêm các nút chức năng vào các panel ở leftFunction
        JButton buttonThem, buttonXoa, buttonSua, buttonXemChiTiet, buttonXuatExcel, buttonTimKiem, buttonLamMoi;
        
        buttonThem = new JButton();
        buttonThem.setBackground(Color.WHITE);
        ImageIcon iconAdd = new ImageIcon("./src/Images/add.png");
        Image img = iconAdd.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);  //Chỉnh sửa kích thước ảnh
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
                addPerformed(tableKho);
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
        ImageIcon iconDelete = new ImageIcon("./src/Images/delete.png");
        Image img2 = iconDelete.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
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
                deletePerformed(tableKho);
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
        ImageIcon iconFix = new ImageIcon("./src/Images/pencil.png");
        Image img3 = iconFix.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
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
                updatePerformed(tableKho);
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
        ImageIcon iconSee = new ImageIcon("./src/Images/eye2.jpg");
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
//                xemPerformed(table);
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
        ImageIcon iconXuat = new ImageIcon("./src/Images/excel1.png");
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
        buttonXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excelExporter ex = new excelExporter();
                ex.excelExporterKhoHang();
                JOptionPane.showMessageDialog(null, "Excel file exported successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
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
//        panelXemChiTiet.add(buttonXemChiTiet);
        panelXuatExcel.add(buttonXuatExcel);
        
        
        
        
        //Tạo và thêm các panel chứa các chức năng tìm kiếm
        JPanel panelCombobox = new JPanel();
        JPanel panelSearchbox = new JPanel();
        JPanel panelLamMoi = new JPanel();
        panelCombobox.setBackground(Color.WHITE);
        panelCombobox.setLayout(null);
        panelSearchbox.setBackground(Color.WHITE);    
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
        String combo[] = {"Tất cả", "A-Z", "Z-A"};
        cb = new JComboBox(combo);
        cb.setBounds(10,20,120,30);
        panelCombobox.add(cb);
        cb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String selectedOption = (String)cb.getSelectedItem();
                switch(selectedOption){
                    case "A-Z":
                        sortAZ();
                        break;
                    case "Z-A":
                        sortZA();
                        break;
                    default:
                        break;
                }
            }
        });
        
        //Tạo textfield để nhập tìm kiếm
        tfTimKiem = new JTextField();
        tfTimKiem.setBounds(10,20,210,30);
        // Tạo nút tìm kiếm
        buttonTimKiem = new JButton();
        buttonTimKiem.setBackground(Color.red);
        ImageIcon iconSearch = new ImageIcon("./src/Images/search.png");
        Image imgTimKiem = iconSearch.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);  
        iconSearch = new ImageIcon(imgTimKiem);

        JLabel lbTimKiem = new JLabel("Tìm kiếm", JLabel.CENTER);
        lbTimKiem.setVerticalAlignment(JLabel.CENTER);

        JPanel panelButtonTimKiem = new JPanel();
        panelButtonTimKiem.setLayout(new BorderLayout());
        panelButtonTimKiem.setBackground(Color.WHITE);
        panelButtonTimKiem.setBounds(0, 0, 90, 40);
        panelButtonTimKiem.add(new JLabel(iconSearch), BorderLayout.WEST);  // Thêm iconSearch vào vị trí phù hợp
        panelButtonTimKiem.add(lbTimKiem, BorderLayout.CENTER);    // Thêm label "Tìm kiếm" vào vị trí phù hợp

        buttonTimKiem.setLayout(null); // Sử dụng BorderLayout cho buttonTimKiem
        buttonTimKiem.add(panelButtonTimKiem); // Thêm panel chứa icon và label vào buttonTimKiem
        buttonTimKiem.setBounds(240, 13, 90, 40);
        panelSearchbox.add(tfTimKiem); panelSearchbox.add(buttonTimKiem);
        
        buttonTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPerformed(tableKho);
            }
        });
        buttonTimKiem.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonTimKiem.setBackground(Color.decode("#D6D6D6")); // Đổi màu khi hover vào
                buttonTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonTimKiem.setBackground(Color.decode("#D6D6D6"));
                
            }
    
            @Override
            public void mouseExited(MouseEvent e){
                buttonTimKiem.setBackground(Color.WHITE); // Quy lại màu bình thường khi hover ra
                panelButtonTimKiem.setBackground(Color.WHITE);
            }
        });
        //Tạo nút Làm mới để reset tìm kiếm
        buttonLamMoi = new JButton();
        buttonLamMoi.setBackground(Color.red);
        ImageIcon iconRefresh = new ImageIcon("./src/Images/refresh.png");
        Image imgLamMoi = iconRefresh.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        iconRefresh = new ImageIcon(imgLamMoi);
        
        JLabel lbLamMoi = new JLabel("Làm mới", JLabel.CENTER);
        lbLamMoi.setVerticalAlignment(JLabel.CENTER);
        
        JPanel panelButtonLamMoi = new JPanel();
        panelButtonLamMoi.setLayout(new BorderLayout());
        panelButtonLamMoi.setBackground(Color.WHITE);
        panelButtonLamMoi.setBounds(0,0,105,40);
        panelButtonLamMoi.add(new JLabel(iconRefresh), BorderLayout.WEST);
        panelButtonLamMoi.add(lbLamMoi, BorderLayout.CENTER);
        
        buttonLamMoi.setLayout(null);
        buttonLamMoi.add(panelButtonLamMoi);
        buttonLamMoi.setBounds(10,13,105,40);
        panelLamMoi.add(buttonLamMoi);
        buttonLamMoi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonLamMoi.setBackground(Color.decode("#D6D6D6"));
                buttonLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonLamMoi.setBackground(Color.decode("#D6D6D6"));
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                buttonLamMoi.setBackground(Color.WHITE);
                panelButtonLamMoi.setBackground(Color.WHITE);
            }
        });
        buttonLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                lamMoi();
            }
        });
        panelLamMoi.add(buttonLamMoi);
    }

    private void loadKhoHangList(){
        tableKho.setModel(modelKho);
        modelKho.addColumn("Mã kho");
        modelKho.addColumn("Tên kho");
        modelKho.addColumn("Địa chỉ");
        modelKho.addColumn("SDT");
        
        arrKhoHang = khoBUS.getAllKhoHang();
        for(int i=0;i<arrKhoHang.size();i++){
            KhoHangDTO khohang = arrKhoHang.get(i);
            String makho = khohang.getMaKho();
            String tenkho = khohang.getTenKho();
            String diachi = khohang.getDiachi();
            String sdt = khohang.getSdt();
            
            Object[] row = {makho, tenkho, diachi, sdt};
            modelKho.addRow(row);
        }
    }
    
    
    private void loadSanPhamList(){
        tableSanPham.setModel(modelSanPham);
        modelSanPham.addColumn("Mã máy");
        modelSanPham.addColumn("Tên máy");
        modelSanPham.addColumn("Số lượng");
        
        arrSanPham = spBUS.getAllSanPham();
        for(int i=0;i<arrSanPham.size();i++){   //Tạo vòng for với size là size của ArrayList
            SanPhamDTO sanpham = arrSanPham.get(i); //Mối dòng là 1 đối tượng (which is a thể hiện của lớp SanPhamDTO).
            String mamay = sanpham.getMaMay();
            String tenmay = sanpham.getTenMay();
            int soluong = sanpham.getSoLuong();
            
            
            Object[] row = {mamay, tenmay, soluong };
            modelSanPham.addRow(row);
        }
    }
    
    public void lamMoi(){
        modelKho.setRowCount(0);
        modelKho.setColumnCount(0);
        loadKhoHangList();
        tfTimKiem.setText("");
        cb.setSelectedItem("Tất cả");
    }
    
    private void addPerformed(JTable tb ){
        PopupKhoHang frameThem = new PopupKhoHang("Thêm kho hàng", "THEM KHO HÀNG", "add");
    }

    private void deletePerformed(JTable tb){
        int selectedRow = tableKho.getSelectedRow();
        if(selectedRow!=-1){
            String makho = (String)modelKho.getValueAt(selectedRow, 0);
            String message = khoBUS.deleteKhoHang(makho);
            if(message.equals("Xóa kho hàng thành công")){
                modelKho.removeRow(selectedRow);
                arrKhoHang.remove(selectedRow);
            }
            JOptionPane.showMessageDialog(this, message);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void updatePerformed(JTable tb){
        int selectedRow = tableKho.getSelectedRow();
        if(selectedRow!=-1){
            PopupKhoHang frameSua = new PopupKhoHang("Sửa kho hàng", "SỬA KHO HÀNG", "fix");
        } else{
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void searchPerformed(JTable tb){
        String searchContent = tfTimKiem.getText().trim();
        if(!searchContent.isEmpty()){
            ArrayList<KhoHangDTO> dsTimKiem = new ArrayList<>();
            
            boolean found = false;
            for(KhoHangDTO khohang: arrKhoHang){
                if(khohang.getMaKho().toLowerCase().contains(searchContent.toLowerCase())||
                   khohang.getTenKho().toLowerCase().contains(searchContent.toLowerCase())||
                   khohang.getDiachi().toLowerCase().contains(searchContent.toLowerCase())||
                   khohang.getSdt().toLowerCase().contains(searchContent.toLowerCase())
                ){
                    dsTimKiem.add(khohang);
                    found = true;
                }
            }
            if(!found){
                JOptionPane.showMessageDialog(this,"Không tìm thấy kho hàng");
                lamMoi();
                return;
            }
            
            DefaultTableModel tbm = (DefaultTableModel) tb.getModel();
            tbm.setRowCount(0);
            
            for(KhoHangDTO khohang: dsTimKiem){
                Object[] row = {
                    khohang.getMaKho(),
                    khohang.getTenKho(),
                    khohang.getDiachi(),
                    khohang.getSdt()
                };
                tbm.addRow(row);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm");
        }
    }
    
    private void sortAZ(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelKho);
        tableKho.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
        int columnIndexSort = 1; // 1 là chỉ số cột tên máy, cần sắp xếp
        sortKeys.add(new RowSorter.SortKey(columnIndexSort, SortOrder.ASCENDING));
        
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
    
    private void sortZA(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelKho);
        tableKho.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
        int columnIndexSort = 1; // 1 là chỉ số cột tên máy, cần sắp xếp
        sortKeys.add(new RowSorter.SortKey(columnIndexSort, SortOrder.DESCENDING));
        
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
    
}
    