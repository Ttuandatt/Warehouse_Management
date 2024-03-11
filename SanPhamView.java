package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
    private int maHangHoa;
    private String tenHangHoa;
    private String donViTinh;
    private double gia;
    private String nhaCungCap;
    private String xuatXu;
    
    //Constructor
    public SanPhamView(){
    }
    public void giaoDienSanPham(){
        setBackground(Color.decode("#6c757d")); 
        setLayout(new GridBagLayout());
        
        JPanel functionBar = new JPanel();
        functionBar.setBackground(Color.YELLOW);
        functionBar.setLayout(new GridBagLayout());
        functionBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5)); //Để cái functionBar nó cách viền 5px ở các cạnh, riêng bottom thì cách 10px
        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);
        content.setLayout(new GridBagLayout());
        content.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5)); //Để cái content nó cách viền 5px ở các cạnh, riêng canh top thì cách 10px
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(functionBar, gbc);
        gbc.weighty = 0.8;
        gbc.gridy = 1;
        add(content, gbc);
        
        //Tạo 2 panel trái, phải chứa các chức năng
        JPanel leftFunction = new JPanel();
        leftFunction.setBackground(Color.RED);
        leftFunction.setBorder(BorderFactory.createTitledBorder("Chức năng"));
//        leftFunction.setBorder(BorderFactory.createTi);
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
        
        //Tạo bảng
        String[][] data = {
                { "AC1", "Laptop Acer Nitro 5", "20", "25.000.000đ"},
                { "AS1", "Laotop Asus TUF", "15", "23.000.000"}
        };  //Tạo dữ liệu cho các ô
        String[] columnNames = {"Mã máy", "Tên máy", "Số lượng", "Giá"};   //Tạo các cột
        JTable table = new JTable(data, columnNames);
        table.setPreferredSize(new Dimension(1400,850));
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
        content.add(sp, gbc);
        
        leftFunction.setLayout(new GridBagLayout());
        rightFunction.setLayout(new GridBagLayout());
        
        JPanel panelThem = new JPanel();
        JPanel panelXoa = new JPanel();
        JPanel panelSua = new JPanel();
        JPanel panelXuatExcel = new JPanel();
        panelThem.setBackground(Color.GRAY);
        panelXoa.setBackground(Color.CYAN);
        panelSua.setBackground(Color.ORANGE);
        panelXuatExcel.setBackground(Color.DARK_GRAY);
 
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 0.3;
        gbc.fill = GridBagConstraints.BOTH;
        leftFunction.add(panelThem, gbc);
        gbc.gridx = 1;
        leftFunction.add(panelXoa, gbc);
        gbc.gridx = 2;
        leftFunction.add(panelSua, gbc);
        gbc.gridx = 3;
        leftFunction.add(panelXuatExcel, gbc);
    }
    
    
}
