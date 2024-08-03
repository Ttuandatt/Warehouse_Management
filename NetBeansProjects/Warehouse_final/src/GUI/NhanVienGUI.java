/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import Lop.PopupNhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class NhanVienGUI extends JPanel{
    NhanVienBUS nvBUS = new NhanVienBUS();
    TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<NhanVienDTO> arrNhanVien = new ArrayList<>();
    private JPanel content1;
    private JTextField tfTimKiem;
    private JComboBox cb;
    
    //Constructor
    public NhanVienGUI(){
        initComponents();
        loadNhanVienList();
    }
    
    
    
    ////////////////////////////// METHODS //////////////////////////////////////
    private void initComponents(){
        table.setDefaultEditor(Object.class, null);
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
        JPanel panelXuatExcel = new JPanel();
        JPanel panelXemChiTiet = new JPanel();
        panelThem.setBackground(Color.WHITE);
        panelXoa.setBackground(Color.WHITE);
        panelSua.setBackground(Color.WHITE);
        panelXuatExcel.setBackground(Color.WHITE);
        panelXemChiTiet.setBackground(Color.WHITE);
        
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
                addPerformed(table);
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
                ex.excelExporterNhanVien();
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
                String selectedOption = (String) cb.getSelectedItem();
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
    
    private void loadNhanVienList(){
        table.setModel(model);
        model.addColumn("Mã NV");
        model.addColumn("Tên NV");
        model.addColumn("Ngày sinh");
        model.addColumn("Giới tính");
        model.addColumn("Địa chỉ");
        model.addColumn("SDT");
        model.addColumn("Ngày vào làm");
        model.addColumn("Loại NV");
        model.addColumn("Kho");
        
        arrNhanVien = nvBUS.getAllNhanVien();
        for(int i = 0;i<arrNhanVien.size();i++){
            NhanVienDTO nv = arrNhanVien.get(i);
            String manv = nv.getManv();
            String tennv = nv.getTennv();
            String ngaysinh = nv.getNgaysinh();
            String gioitinh = nv.getGioitinh();
            String diachi = nv.getDiachi();
            String sdt = nv.getSdt();
            String ngayvao = nv.getNgayvao();
            int loai = nv.getLoai();
            String kho = nv.getKho();
            
            Object[] row = {manv, tennv, ngaysinh, gioitinh, diachi, sdt, ngayvao, loai, kho};
            model.addRow(row);
        }
    }
    
    private void lamMoi(){
        model.setRowCount(0);
        model.setColumnCount(0);
        loadNhanVienList();
        tfTimKiem.setText("");
        cb.setSelectedItem("Tất cả");
    }
    
    private void addPerformed(JTable tb){
        PopupNhanVien frameThem = new PopupNhanVien("Thêm nhân viên", "THÊM NHÂN VIÊN", "add");
    }
    
    private void deletePerformed(JTable tb){
        int selectedRow = table.getSelectedRow();
        if(selectedRow!=-1){
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa nhân viên?", "Xác nhận xóa", JOptionPane.OK_CANCEL_OPTION);
            if(dialogResult == JOptionPane.OK_OPTION){
                String manv = (String) model.getValueAt(selectedRow, 0);
                String messageNV = nvBUS.deleteNhanVien(manv);
                String messageTK = tkBUS.deleteTaiKhoan(manv);
                if(messageNV.equals("Xóa nhân viên thành công")){
                    model.removeRow(selectedRow);
                    arrNhanVien.remove(selectedRow);
                }
                
                JOptionPane.showMessageDialog(this,"Xóa nhân viên và tài khoản thành công");
            }
        } else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng để xóa");
        }
    }
    
    private void suaPerformed(JTable tb){
        int selectedrow = table.getSelectedRow();
        if(selectedrow!=-1){
            PopupNhanVien frameSua = new PopupNhanVien("Sửa nhân viên", "SỬA NHÂN VIÊN", "fix");
        } else{
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để sửa");
        }
    }
    
     private void searchPerformed(JTable tb){
        String searchContent = tfTimKiem.getText().trim(); // Lấy nội dung tìm kiếm từ textField và loại bỏ khoảng trắng ở đầu và cuối chuỗi
        if (!searchContent.isEmpty()) { // Kiểm tra xem nội dung tìm kiếm có rỗng không
            ArrayList<NhanVienDTO> dsTimKiem = new ArrayList<>(); // Tạo một danh sách để lưu trữ kết quả tìm kiếm

            // Duyệt qua danh sách sản phẩm và lọc những sản phẩm thỏa mãn điều kiện tìm kiếm
            boolean found = false;
            for (NhanVienDTO nv: arrNhanVien) {
                // Kiểm tra xem thông tin của sản phẩm có chứa chuỗi tìm kiếm hay không (sử dụng phương thức contains)
                if (nv.getManv().toLowerCase().contains(searchContent.toLowerCase()) ||
                    nv.getTennv().toLowerCase().contains(searchContent.toLowerCase())||
                    nv.getNgaysinh().toLowerCase().contains(searchContent.toLowerCase())||
                    nv.getGioitinh().toLowerCase().contains(searchContent.toLowerCase())||
                    nv.getDiachi().toLowerCase().contains(searchContent.toLowerCase())||
                    nv.getSdt().toLowerCase().contains(searchContent.toLowerCase())||
                    nv.getNgayvao().toLowerCase().contains(searchContent.toLowerCase())||
                    nv.getKho().toLowerCase().contains(searchContent.toLowerCase())
                ) {
                    dsTimKiem.add(nv); // Nếu sản phẩm thỏa mãn, thêm vào danh sách lọc
                    found = true;
                }
                
            }
            // Kiểm tra nếu không tìm thấy sản phẩm nào
            if(!found){
                JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
                lamMoi();
                return; // Kết thúc phương thức sau khi hiển thị thông báo
            }
            
            // Xóa tất cả các dòng hiện có trong bảng
            DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
            tableModel.setRowCount(0);

            // Thêm các sản phẩm thỏa mãn vào bảng
            for (NhanVienDTO nv : dsTimKiem) {
                Object[] row = {
                    nv.getManv(), 
                    nv.getTennv(),
                    nv.getNgaysinh(),
                    nv.getGioitinh(),
                    nv.getDiachi(),
                    nv.getSdt(),
                    nv.getNgayvao(),
                    nv.getLoai(),
                    nv.getKho()
                };
                tableModel.addRow(row);
            }
        } else {
            // Nếu người dùng không nhập nội dung tìm kiếm, thực hiện làm mới bảng để hiển thị tất cả sản phẩm
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm");
            lamMoi();
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
}
