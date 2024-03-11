/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        JPanel content = new JPanel();
        content.setBackground(Color.GRAY);
        
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
        leftFunction.setBorder(BorderFactory.createTitledBorder("CHỨC NĂNG"));
        JPanel rightFunction = new JPanel();
        rightFunction.setBackground(Color.BLUE);
        rightFunction.setBorder(BorderFactory.createTitledBorder("TÌM KIẾM"));
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
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };
        String[] columnNames = {"Name", "Roll Number", "Department"};
        //Tạo bảng
        JTable table = new JTable(data, columnNames);
        table.setPreferredSize(new Dimension(1400, 850));
        JScrollPane sp = new JScrollPane(table);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        content.add(sp, gbc);
        
    }
    
}
/*
setLayout(new BorderLayout());
        JPanel functionBar = new JPanel();  //Panel chứa các chức năng
        functionBar.setBackground(Color.YELLOW);
        functionBar.setLayout(new GridBagLayout());
        functionBar.setPreferredSize(new Dimension(getWidth(), 120));
        
        add(functionBar, BorderLayout.NORTH);
        
        
        JPanel leftFunction = new JPanel();
        leftFunction.setBorder(BorderFactory.createTitledBorder("Chức năng"));
        JPanel rightFunction = new JPanel();
        rightFunction.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;  //Định tỷ lể widen theo chiều ngang - chiếm 0.4 phần functionBar panel
        gbc.weighty = 1.0;  //Định tỷ lệ widen theo chiều dọc hết cỡ cái functionBar panel
        gbc.fill = GridBagConstraints.BOTH;   //Thực hiện widen theo cả 2 chiều
        functionBar.add(leftFunction, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.6;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        functionBar.add(rightFunction, gbc);
        JButton b1 = new JButton("EAST");
        add(b1, BorderLayout.EAST);
        JPanel content = new JPanel();
        content.setBackground(Color.GRAY);
        add(content, BorderLayout.CENTER);
        content.setPreferredSize(new Dimension(1400-(700/3), 800));
        
        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };
        String[] columnNames = {"Name", "Roll Number", "Department"};
        //Tạo bảng
        JTable table = new JTable(data, columnNames);
        table.setPreferredSize(new Dimension(1400, 850));
        JScrollPane sp = new JScrollPane(table);
        content.add(sp);
*/
