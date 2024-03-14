package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author ACER
 */
public class SanPhamView extends JPanel {
    //Constructor
    public void giaoDienSanPham(){
        setLayout(new FlowLayout());
        setBackground(Color.decode("#6c757d")); 
        setLayout(new GridBagLayout());
        
        JPanel functionBar = new JPanel();
        functionBar.setBackground(Color.YELLOW);
        functionBar.setLayout(new GridBagLayout());
        functionBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5)); //Để cái functionBar nó cách viền 5px ở các cạnh, riêng bottom thì cách 10px
        JPanel content1 = new JPanel();
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
        
        String[][] data = {
            {"AC1","Laptop Acer Nitro 5","20", "25.00.000đ", "Intel i3 1115G4", "4GB", "256GB"},
            {"AS1","Laptop Asus TUF 15","23","23.000.000đ", "Intel i5 12500H", "8GB", "256GB"}
        };
        String columnNames[] = {"Mã máy","Tên máy", "Số lượng", "Giá", "Bộ xử lý", "RAM", "Bộ nhớ"};
        JTable table = new JTable(data, columnNames);
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
        panelXoa.add(labelXoa,BorderLayout.SOUTH);
        panelSua.add(labelSua,BorderLayout.SOUTH);
        panelXuatExcel.add(labelXuatExcel,BorderLayout.SOUTH);
        
        
        
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
    }
    
}
