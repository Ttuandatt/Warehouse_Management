package GUI;

import DTO.SanPhamDTO;
import Lop.PopupSanPham;
import DAO.SanPhamDAO;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER
 */
public class SanPhamGUI extends JPanel {
    SanPhamBUS spBUS = new SanPhamBUS();
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    private ArrayList<SanPhamDTO> arrSanPham = new ArrayList<>(); //Tạo ArrayList sp với kiểu là SanPhamDTO
    private JComboBox cb;
    private JPanel content1;
    private JTextField tfTimKiem, tfPriceStart, tfPriceEnd;
    
    //Constructor
    public SanPhamGUI(){
        initComponents();
        loadSanPhamList();
    }
    
    
    //////////////////////////////////////////METHODS//////////////////////////////////////
    private void initComponents(){
        table.setDefaultEditor(Object.class, null); // không cho click vào & edit nội dung các cell trong bảng
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
        
        JScrollPane sp = new JScrollPane(table);
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
        JPanel panelXemChiTiet = new JPanel();
        JPanel panelTangSoLuong = new JPanel();
        JPanel panelXuatExcel = new JPanel();
        panelThem.setBackground(Color.WHITE);
        panelXoa.setBackground(Color.WHITE);
        panelSua.setBackground(Color.WHITE);
        panelTangSoLuong.setBackground(Color.WHITE);
        panelXemChiTiet.setBackground(Color.WHITE);
        panelXuatExcel.setBackground(Color.WHITE);
        
        
        panelXoa.setBounds(20, 20, 50, 60);
        panelXoa.setLayout(null);
        panelSua.setBounds(70,20,50,60);
        panelSua.setLayout(null);
        panelXemChiTiet.setBounds(120,20,80,60);
        panelXemChiTiet.setLayout(null);
        panelXuatExcel.setBounds(270,20,95,60);
        panelXuatExcel.setLayout(null);
        
        
        leftFunction.add(panelThem);
        leftFunction.add(panelXoa);
        leftFunction.add(panelSua);
        leftFunction.add(panelTangSoLuong);
        leftFunction.add(panelXemChiTiet);
        leftFunction.add(panelXuatExcel);
        
        
        
        //Thêm các nút chức năng vào các panel ở leftFunction
        JButton buttonThem, buttonXoa, buttonSua, buttonXemChiTiet, buttonTangSoLuong, buttonXuatExcel, buttonTimKiem, buttonLamMoi;
        
//        buttonThem = new JButton();
//        buttonThem.setBackground(Color.WHITE);
//        ImageIcon iconAdd = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\add.png");
//        Image img = iconAdd.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);  //Chỉnh sửa kích thước ảnh
//        iconAdd = new ImageIcon(img);       //Tạo lại iconAdd bằng ảnh vừa được chỉnh sửa kích thước
//        
//        JLabel lbThem = new JLabel("Thêm", JLabel.CENTER);
//        lbThem.setVerticalAlignment(JLabel.BOTTOM);
//        
//        JPanel panelButtonThem = new JPanel();
//        panelButtonThem.setLayout(new BorderLayout());
//        panelButtonThem.setBackground(Color.WHITE);
//        panelButtonThem.setBounds(0,0,50,60);
//        panelButtonThem.add(new JLabel(iconAdd), BorderLayout.CENTER);  //Add ảnh vào vị trí giữa button
//        panelButtonThem.add(lbThem, BorderLayout.SOUTH);    //Add label "Thêm" vào bottom của button
//        
//        buttonThem.setLayout(null);
//        buttonThem.setBounds(0,0,50,60);
//        buttonThem.add(panelButtonThem);
//        buttonThem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addPerformed(table);
//            }
//        });
//        buttonThem.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseEntered(MouseEvent e){
//                buttonThem.setBackground(Color.decode("#D6D6D6")); // Đổi màu khi hover vào
//                buttonThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                panelButtonThem.setBackground(Color.decode("#D6D6D6"));
//                
//            }
//    
//            @Override
//            public void mouseExited(MouseEvent e){
//                buttonThem.setBackground(Color.WHITE); // Quy lại màu bình thường khi hover ra
//                panelButtonThem.setBackground(Color.WHITE);
//            }
//        });
        
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
                deletePerformed(table);
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
                updatePerformed(table);
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
                xemPerformed(table);
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
        
//        buttonTangSoLuong = new JButton();
//        buttonTangSoLuong.setBackground(Color.WHITE);
//        ImageIcon iconTangSoLuong = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\increase.png");
//        Image imgTangSoLuong = iconTangSoLuong.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);  //Chỉnh sửa kích thước ảnh
//        iconTangSoLuong = new ImageIcon(imgTangSoLuong);       //Tạo lại iconAdd bằng ảnh vừa được chỉnh sửa kích thước
//        
//        JLabel lbTangSoLuong = new JLabel("Tăng số lượng", JLabel.CENTER);
//        lbTangSoLuong.setVerticalAlignment(JLabel.BOTTOM);
//        
//        JPanel panelButtonTangSoLuong = new JPanel();
//        panelButtonTangSoLuong.setLayout(new BorderLayout());
//        panelButtonTangSoLuong.setBackground(Color.WHITE);
//        panelButtonTangSoLuong.setBounds(0,0,95,60);
//        panelButtonTangSoLuong.add(new JLabel(iconTangSoLuong), BorderLayout.CENTER);  //Add ảnh vào vị trí giữa button
//        panelButtonTangSoLuong.add(lbTangSoLuong, BorderLayout.SOUTH);    //Add label "Thêm" vào bottom của button
//        
//        buttonTangSoLuong.setLayout(null);
//        buttonTangSoLuong.setBounds(0,0,95,60);
//        buttonTangSoLuong.add(panelButtonTangSoLuong);
//        buttonTangSoLuong.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                tangSoLuongPerformed(table);
//            }
//        });
//        buttonTangSoLuong.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseEntered(MouseEvent e){
//                buttonTangSoLuong.setBackground(Color.decode("#D6D6D6")); // Đổi màu khi hover vào
//                buttonTangSoLuong.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                panelButtonTangSoLuong.setBackground(Color.decode("#D6D6D6"));
//                
//            }
//    
//            @Override
//            public void mouseExited(MouseEvent e){
//                buttonTangSoLuong.setBackground(Color.WHITE); // Quy lại màu bình thường khi hover ra
//                panelButtonTangSoLuong.setBackground(Color.WHITE);
//            }
//        });
        
        
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
        panelButtonXuat.setBounds(0,0,95,60);
        panelButtonXuat.add(new JLabel(iconSee), BorderLayout.CENTER);
        panelButtonXuat.add(lbXuat, BorderLayout.SOUTH);
        
        buttonXuatExcel.setLayout(null);
        buttonXuatExcel.setBounds(0,0,95,60);
        buttonXuatExcel.add(panelButtonXuat);
        buttonXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excelExporter ex = new excelExporter();
                ex.excelExporterSanPham();
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
        
//        panelThem.add(buttonThem);
        panelXoa.add(buttonXoa);
        panelSua.add(buttonSua);
        panelXemChiTiet.add(buttonXemChiTiet);
//        panelTangSoLuong.add(buttonTangSoLuong);
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
        gbc.weightx = 0.15;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH; 
        rightFunction.add(panelCombobox, gbc);
        gbc.weightx = 0.69;
        gbc.gridx = 1;
        rightFunction.add(panelSearchbox, gbc);
        gbc.weightx = 0.16;
        gbc.gridx = 2;
        rightFunction.add(panelLamMoi, gbc);
        
//        JLabel lbType = new JLabel("Tìm theo");
//        lbType.setBounds(6,4,50,30);
        //Tạo combobox
        String combo[] = {"Tất cả", "A-Z", "Z-A", "Giá tăng dần", "Giá giảm dần"};
        cb = new JComboBox(combo);
        cb.setBounds(5,21,90,30);
        panelCombobox.add(cb);
//        panelCombobox.add(lbType);
        
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
                    case "Giá tăng dần":
                        sortPriceAscending();
                        break;
                    case "Giá giảm dần":
                        sortPriceDescending();
                        break;
                    default:
                        break;
                }
            }
        });
        
        //Tạo textfield để nhập tìm kiếm
        JLabel lbPrice = new JLabel("Giá");
        lbPrice.setBounds(6,4,20,30);
        JLabel lbDash = new JLabel("-");
        lbDash.setBounds(96,35,10,5);
        tfPriceStart = new JTextField();
        tfPriceStart.setBounds(5,21,90,30);
        
        tfPriceEnd = new JTextField();
        tfPriceEnd.setBounds(100,21,90,30);
        
        JLabel lbDifferent = new JLabel("Khác");
        lbDifferent.setBounds(221,4,30,30);
        tfTimKiem = new JTextField();
        tfTimKiem.setBounds(220,21,150,30);
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
        buttonTimKiem.setBounds(375, 15, 90, 40);
//        panelSearchbox.add(lbPrice);
        panelSearchbox.add(lbDash);
//        panelSearchbox.add(lbDifferent);
        panelSearchbox.add(tfTimKiem); 
        panelSearchbox.add(tfPriceStart);
        panelSearchbox.add(tfPriceEnd);
        panelSearchbox.add(buttonTimKiem);
        
        buttonTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPerformed(table);
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
        buttonLamMoi.setBounds(4,15,105,40);
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
    
    private void loadSanPhamList(){
        table.setModel(model);
        model.addColumn("Mã máy");
        model.addColumn("Tên máy");
        model.addColumn("Số lượng");
        model.addColumn("Giá");
        model.addColumn("Bộ xử lý");
        model.addColumn("RAM");
        model.addColumn("Bộ nhớ");
        model.addColumn("GPU");
        model.addColumn("Kho");
        
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(250);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(70);
        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    //Ngăn các cột tự resize
        table.setRowHeight(30);
        
        arrSanPham = spBUS.getAllSanPham(); //Lấy tất cả sản phẩm bằng phương thức của SanPhamBUS
        for(int i=0;i<arrSanPham.size();i++){   //Tạo vòng for với size là size của ArrayList
            SanPhamDTO sanpham = arrSanPham.get(i); //Mối dòng là 1 đối tượng (which is a thể hiện của lớp SanPhamDTO).
            String mamay = sanpham.getMaMay();
            String tenmay = sanpham.getTenMay();
            int soluong = sanpham.getSoLuong();
            int gia = sanpham.getGia();
            String boxuly = sanpham.getBoXuLy();
            String ram = sanpham.getRam();
            String bonho = sanpham.getBoNho();
            String gpu = sanpham.getGPU();
            String kho = sanpham.getMaKho();
            
            Object[] row = {mamay, tenmay, soluong, gia, boxuly, ram, bonho, gpu, kho};
            model.addRow(row);
        }
    
    }
    
    
    
    private void lamMoi(){
        // Xóa tất cả các dòng trong mô hình bảng
        model.setRowCount(0);
        loadSanPhamList();
        tfTimKiem.setText("");
        tfPriceStart.setText("");
        tfPriceEnd.setText("");
        cb.setSelectedItem("Tất cả");
    }
    
    private void addPerformed(JTable tb){
        PopupSanPham frameThem = new PopupSanPham("Thêm sản phẩm", "THÊM SẢN PHẨM","add");
    }
    
    private void deletePerformed(JTable tb){
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) { // -1 nếu không có dòng nào được chọn
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa sản phẩm?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
            if(dialogResult == JOptionPane.OK_OPTION){
                String masp = (String) model.getValueAt(selectedRow, 0);
                String message = spBUS.deleteSanPham(masp);
                if(message.equals("Xóa sản phẩm thành công")){
                    model.removeRow(selectedRow);
                    arrSanPham.remove(selectedRow);
                }
                JOptionPane.showMessageDialog(this, message);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void updatePerformed(JTable tb){
        int selectedRow = table.getSelectedRow();
        if(selectedRow != -1){
            PopupSanPham frameSua = new PopupSanPham("Sửa sản phẩm", "SỬA SẢN PHẨM","fix");
        } else{
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void searchPerformed(JTable tb){
        String searchContent = tfTimKiem.getText().trim();
        String priceStartString = tfPriceStart.getText().trim();
        String priceEndString = tfPriceEnd.getText().trim();
        //Trường hợp tìm bằng các thông tin khác ngoài giá
        if(!searchContent.isEmpty() && priceStartString.isEmpty() && priceEndString.isEmpty()){
            ArrayList<SanPhamDTO> dsTimKiem1 = new ArrayList<>();
            
            boolean found = false;
            for(SanPhamDTO sanPham: arrSanPham){ //Duyệt qua tất cả sản phẩm đang có trong bảng
                if (sanPham.getMaMay().toLowerCase().contains(searchContent.toLowerCase()) ||
                    sanPham.getTenMay().toLowerCase().contains(searchContent.toLowerCase())||
                    sanPham.getBoNho().toLowerCase().contains(searchContent.toLowerCase()) ||
                    sanPham.getBoXuLy().toLowerCase().contains(searchContent.toLowerCase())||
                    sanPham.getGPU().toLowerCase().contains(searchContent.toLowerCase())   ||
                    sanPham.getNhaCungCap().toLowerCase().contains(searchContent.toLowerCase())||
                    sanPham.getRam().toLowerCase().contains(searchContent.toLowerCase())||
                    sanPham.getMaKho().toLowerCase().contains(searchContent.toLowerCase())
                ){
                    found = true;
                    dsTimKiem1.add(sanPham);
                }
            }
            if(!found){
                JOptionPane.showMessageDialog(this,"Không tìm thấy sản phẩm");
                lamMoi();
                return;
            }
            
            // Làm mới bảng & set bảng về 0
            DefaultTableModel tbm = (DefaultTableModel)tb.getModel();
            tbm.setRowCount(0);
            
            // Thêm các sản phẩm thỏa mãn vào bảng
            for(SanPhamDTO sanPham: dsTimKiem1){
                Object[] row ={
                    sanPham.getMaMay(),
                    sanPham.getTenMay(),
                    sanPham.getSoLuong(),
                    sanPham.getGia(),
                    sanPham.getBoXuLy(),
                    sanPham.getBoNho(),
                    sanPham.getRam(),
                    sanPham.getGPU(),
                    sanPham.getMaKho()
                };
                tbm.addRow(row);
            }
        
        }
        //Trường hợp tìm bằng giá
        else if(searchContent.isEmpty() && !priceStartString.isEmpty() && !priceEndString.isEmpty()){
            int priceStartInt = Integer.parseInt(tfPriceStart.getText().trim());
            int priceEndInt = Integer.parseInt(tfPriceEnd.getText().trim());
            ArrayList<SanPhamDTO> dsTimKiem2 = new ArrayList<>();
            
            boolean found = false;
            for(SanPhamDTO sanPham: arrSanPham){
                if(sanPham.getGia() >= priceStartInt && sanPham.getGia()<= priceEndInt){
                    found = true;
                    dsTimKiem2.add(sanPham);
                }
            }
            if(!found){
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
                lamMoi();
                return;
            }
            
            // Làm mới bảng & set bảng về 0
            DefaultTableModel tbm = (DefaultTableModel)tb.getModel();
            tbm.setRowCount(0);
            
            //Thêm các sản phẩm thỏa mãn vào bảng
            for(SanPhamDTO sanPham: dsTimKiem2){
                Object[] row = {
                    sanPham.getMaMay(),
                    sanPham.getTenMay(),
                    sanPham.getSoLuong(),
                    sanPham.getGia(),
                    sanPham.getBoXuLy(),
                    sanPham.getBoNho(),
                    sanPham.getRam(),
                    sanPham.getGPU(),
                    sanPham.getMaKho()
                };
                tbm.addRow(row);
            }
        }
        else if(searchContent.isEmpty() || priceStartString.isEmpty() || priceEndString.isEmpty()){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập đủ thông tin tìm kiếm");
        }
        else if(searchContent.isEmpty() && priceStartString.isEmpty() && priceEndString.isEmpty()){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập thông tin tìm kiếm");
        }
    }
    private void tangSoLuongPerformed(JTable tb){
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String masp = table.getValueAt(selectedRow, 0).toString();
            String input = JOptionPane.showInputDialog("Nhập số lượng");
            if (input != null) {
                try {
                    int soLuong = Integer.parseInt(input);
                    SanPhamDTO spDTO = new SanPhamDTO();
                    spDTO.setSoLuong(soLuong);
                    JOptionPane.showMessageDialog(null, spBUS.tangSoLuong(masp, soLuong));

                    JOptionPane.showMessageDialog(null, "Số lượng đã được cập nhật");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ. Vui lòng nhập lại.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để tăng số lượng.");
        }
    }   
    
    private void sortAZ(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
        int columnIndexSort = 1; // 1 là chỉ số cột tên máy, cần sắp xếp
        sortKeys.add(new RowSorter.SortKey(columnIndexSort, SortOrder.ASCENDING));
        
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
    
    private void sortZA(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
        int columnIndexSort = 1; // 1 là chỉ số cột tên máy, cần sắp xếp
        sortKeys.add(new RowSorter.SortKey(columnIndexSort, SortOrder.DESCENDING));
        
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
    
    private void sortPriceAscending(){
        // Sử dụng phương pháp sort của Collections để sắp xếp ArrayList arrSanPham theo giá tăng dần
        Collections.sort(arrSanPham, new Comparator<SanPhamDTO>() {
            @Override
            public int compare(SanPhamDTO sp1, SanPhamDTO sp2) {
                return sp1.getGia() - sp2.getGia();
            }
        });
    
        // Xóa dữ liệu hiện tại của bảng
        model.setRowCount(0);
    
        // Thêm lại dữ liệu đã được sắp xếp vào bảng
        for(SanPhamDTO sanpham : arrSanPham){
            Object[] row = {
                sanpham.getMaMay(),
                sanpham.getTenMay(),
                sanpham.getSoLuong(),
                sanpham.getGia(),
                sanpham.getBoXuLy(),
                sanpham.getRam(),
                sanpham.getBoNho(),
                sanpham.getGPU(),
                sanpham.getMaKho()
            };
            model.addRow(row);
        }
    }
    
    private void sortPriceDescending(){
        // Sử dụng phương pháp sort của Collections để sắp xếp ArrayList arrSanPham theo giá tăng dần
        Collections.sort(arrSanPham, new Comparator<SanPhamDTO>() { //Đối số thứ hai của Collections.sort là một đối tượng Comparator được tạo ra để so sánh các đối tượng SanPhamDTO dựa trên giá của chúng
            @Override
            public int compare(SanPhamDTO sp1, SanPhamDTO sp2) {
                return sp2.getGia() - sp1.getGia();
            }
        });
    
        // Xóa dữ liệu hiện tại của bảng
        model.setRowCount(0);
    
        // Thêm lại dữ liệu đã được sắp xếp vào bảng
        for(SanPhamDTO sanpham : arrSanPham){
            Object[] row = {
                sanpham.getMaMay(),
                sanpham.getTenMay(),
                sanpham.getSoLuong(),
                sanpham.getGia(),
                sanpham.getBoXuLy(),
                sanpham.getBoNho(),
                sanpham.getRam(),
                sanpham.getGPU(),
                sanpham.getMaKho()
            };
            model.addRow(row);
        }
    }
    
    private void xemPerformed(JTable tb){
        int selectedRow = table.getSelectedRow();
        if(selectedRow!=-1){
            JLabel lbMaSP, lbTenSP, lbSoLuong,lbGia,lbBoXuLy,lbBoNho,lbRam, lbGPU, lbSize, lbNhaCC, lbKho;
            JTextField tfMaSP, tfTenSP, tfSoLuong,tfGia, tfGPU, tfSize, tfNhaCC, tfKho;
            JComboBox<String> cb1, cb2, cb3;
            // Ở SanPhamDAO tạo 1 phương thức getSanPhamByMaSP để lấy thông tin về sản phẩm ở dòng được chọn
            // Sau đó tạo 1 đối tượng của lớp SanPham để chứa các thông tin đó
            // Qua đây thì lấy thông tin từ đối tượng SanPham rồi truyền vào các label data, sau đó add vào panel để hiển thị
            
            JFrame f = new JFrame("Thông tin");

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
            JLabel lb = new JLabel("CHI TIẾT SẢN PHẦM");
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
            JPanel pnMa, pnTen, pnSoluong, pnGia, pnBoXuLy, pnBoNho,pnRam,pnVGA,pnSize,pnNhaCC, pnKho, pnOption;

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
            pnVGA = new JPanel();
            pnVGA.setBackground(Color.WHITE);
            pnSize = new JPanel();
            pnSize.setBackground(Color.WHITE);
            pnNhaCC = new JPanel();
            pnNhaCC.setBackground(Color.WHITE);
            pnKho = new JPanel();
            pnKho.setBackground(Color.WHITE);
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
            content.add(pnVGA, gbc);

            gbc.gridx = 2;
            gbc.gridy = 0;
            content.add(pnSize, gbc);
            gbc.gridy = 1;
            content.add(pnNhaCC, gbc);
            gbc.gridy = 2;
            content.add(pnKho, gbc);
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
            lbGPU = new JLabel("VGA");
            lbSize = new JLabel("Kích thước màn");
            lbNhaCC = new JLabel("Nhà cung cấp");
            lbKho = new JLabel("Kho");

            tfMaSP = new JTextField();
            tfTenSP = new JTextField();
            tfSoLuong = new JTextField();
            tfGia = new JTextField();
            tfGPU = new JTextField();
            tfSize = new JTextField();
            tfNhaCC = new JTextField();
            tfKho = new JTextField();

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
            pnVGA.setLayout(null);
            pnVGA.add(lbGPU); pnVGA.add(tfGPU);

            lbSize.setBounds(60,5,90,20);
            tfSize.setBounds(60,25,180,30);
            pnSize.setLayout(null);
            pnSize.add(lbSize); pnSize.add(tfSize);

            lbNhaCC.setBounds(60,5,90,20);
            tfNhaCC.setBounds(60,25,180,30);
            pnNhaCC.setLayout(null);
            pnNhaCC.add(lbNhaCC);   pnNhaCC.add(tfNhaCC);

            lbKho.setBounds(60,5,90,20);
            tfKho.setBounds(60,25,180,30);
            pnKho.setLayout(null);
            pnKho.add(lbKho);   pnKho.add(tfKho);


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

            String maSP = table.getValueAt(selectedRow, 0).toString();
            SanPhamDAO spDAO = new SanPhamDAO();
            SanPhamDTO sp = spDAO.getByID(maSP);
            if(sp!=null){
                tfMaSP.setText(sp.getMaMay());
                tfTenSP.setText(sp.getTenMay());
                tfSoLuong.setText(String.valueOf(sp.getSoLuong()));
                tfGia.setText(String.valueOf(sp.getGia()));
                tfGPU.setText(sp.getGPU());
                tfSize.setText(sp.getKichthuocman());
                tfNhaCC.setText(sp.getNhaCungCap());
                tfKho.setText(sp.getMaKho());
                cb1.setSelectedItem(sp.getBoXuLy());
                cb2.setSelectedItem(sp.getBoNho());
                cb3.setSelectedItem(sp.getRam());
            }

            tfMaSP.setEditable(false);
            tfTenSP.setEditable(false);
            tfSoLuong.setEditable(false);
            tfGia.setEditable(false);
            tfGPU.setEditable(false);
            tfSize.setEditable(false);
            tfNhaCC.setEditable(false);
            tfKho.setEditable(false);
            cb1.setEnabled(false);
            cb2.setEnabled(false);
            cb3.setEnabled(false);


            tfMaSP.setFocusable(false);
            tfTenSP.setFocusable(false);
            tfSoLuong.setFocusable(false);
            tfGia.setFocusable(false);
            tfGPU.setFocusable(false);
            tfSize.setFocusable(false);
            tfNhaCC.setFocusable(false);
            tfKho.setFocusable(false);
            cb1.setFocusable(false);
            cb2.setFocusable(false);
            cb3.setFocusable(false);


            f.setResizable(false);
            f.setVisible(true); // Hiển thị JFrame
            }
            else{
                JOptionPane.showMessageDialog(null,"Vui lòng chọn 1 dòng để xem chi tiết");
            }
        }
    

    

}

