/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.PhieuXuatDTO;
import DTO.CTPhieuXuatDTO;
import BUS.PhieuXuatBUS;
import BUS.CTPhieuXuatBUS;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ACER
 */
public class PhieuXuatGUI extends JPanel {
    private JTable exportTable = new JTable();
    private JTable exportDetailTable = new JTable();
    private DefaultTableModel exportModel = new DefaultTableModel();
    private DefaultTableModel exportDetailModel = new DefaultTableModel();
    private JTextField tfSearchLeft, tfSearchRight;
    private ArrayList<PhieuXuatDTO> arrPX = new ArrayList<>();
    private ArrayList<CTPhieuXuatDTO> arrCTPX = new ArrayList<>();
    private PhieuXuatBUS pxBUS = new PhieuXuatBUS();
    private CTPhieuXuatBUS ctpxBUS = new CTPhieuXuatBUS();
    private JPanel searchPanelLeft, exportTablePanelLeft;
    private JPanel searchPanelRight, exportTablePanelRight;
    
    public PhieuXuatGUI() {
        initComponents();
    }

    private void initComponents() {
        exportTable.setDefaultEditor(Object.class, null);
        exportDetailTable.setDefaultEditor(Object.class, null);
        setLayout(new GridLayout(1, 2));
        setBackground(Color.WHITE);

        JPanel leftPanel, rightPanel;
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        add(leftPanel);
        add(rightPanel);

        // leftPanel chứa bảng phieuxuat
        leftPanel.setLayout(new GridBagLayout());
        searchPanelLeft = new JPanel();
        searchPanelLeft.setBackground(Color.WHITE);
        exportTablePanelLeft = new JPanel();
        exportTablePanelLeft.setBackground(Color.WHITE);
        exportTablePanelLeft.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.weightx = 1;
        gbc.weighty = 0.15;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(searchPanelLeft, gbc);
        gbc.weighty = 0.85;
        gbc.gridy = 1;
        leftPanel.add(exportTablePanelLeft, gbc);

        searchPanelLeft.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        searchPanelLeft.setLayout(new GridBagLayout());
        JPanel searchBoxPanelLeft, optionButtonPanelLeft;
        searchBoxPanelLeft = new JPanel();
        searchBoxPanelLeft.setBackground(Color.WHITE);
        searchBoxPanelLeft.setLayout(null);
        optionButtonPanelLeft = new JPanel();
        optionButtonPanelLeft.setBackground(Color.WHITE);
        optionButtonPanelLeft.setLayout(null); // Đặt layout là null

        gbc.weightx = 0.6;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        searchPanelLeft.add(searchBoxPanelLeft, gbc);
        gbc.weightx = 0.34;
        gbc.gridx = 1;
        searchPanelLeft.add(optionButtonPanelLeft, gbc);

        // Tạo và thêm các thành phần tìm kiếm trong searchBoxPanelLeft
        tfSearchLeft = new JTextField();
        tfSearchLeft.setBounds(5, 15, 270, 30);
        JButton searchButtonLeft = new JButton("Tìm");
        searchButtonLeft.setBounds(282, 15, 60, 30);
        searchBoxPanelLeft.add(tfSearchLeft);
        searchBoxPanelLeft.add(searchButtonLeft);

        // Tạo và thêm các nút "Tìm" và "Làm mới" trong searchButtonPanelLeft
        JButton refreshButtonLeft = new JButton("Làm mới");
        refreshButtonLeft.setBounds(0, 15, 85, 30);
        JButton excelButtonLeft = new JButton("Xuất Excel");
        excelButtonLeft.setBounds(95, 15, 90, 30);
        
        optionButtonPanelLeft.add(refreshButtonLeft);
        optionButtonPanelLeft.add(excelButtonLeft);

        // Thêm JScrollPane chứa exportTable vào exportTablePanelLeft
        JScrollPane spPX = new JScrollPane(exportTable);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        exportTablePanelLeft.add(spPX, gbc);
        loadExportList();

        searchButtonLeft.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                searchButtonLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
                searchButtonLeft.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                searchButtonLeft.setBackground(Color.WHITE);
            }
        });
//        searchButtonLeft.addActionListener(new ActionListener(){
//            @Override
//            public void 
//        });
//        
        
        refreshButtonLeft.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                refreshButtonLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
                refreshButtonLeft.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                refreshButtonLeft.setBackground(Color.WHITE);
            }
        });
        
        excelButtonLeft.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                excelButtonLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
                excelButtonLeft.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                excelButtonLeft.setBackground(Color.WHITE);
            }
        });
        
        // rightPanel chứa bảng ctphieuxuat
        rightPanel.setLayout(new GridBagLayout());
        searchPanelRight = new JPanel();
        searchPanelRight.setBackground(Color.WHITE);
        exportTablePanelRight = new JPanel();
        exportTablePanelRight.setBackground(Color.WHITE);
        exportTablePanelRight.setLayout(new GridBagLayout());

        gbc.weightx = 1;
        gbc.weighty = 0.15;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPanel.add(searchPanelRight, gbc);
        gbc.weighty = 0.85;
        gbc.gridy = 1;
        rightPanel.add(exportTablePanelRight, gbc);

        searchPanelRight.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        searchPanelRight.setLayout(new GridBagLayout());
        JPanel searchBoxPanelRight, optionButtonPanelRight;
        searchBoxPanelRight = new JPanel();
        searchBoxPanelRight.setBackground(Color.WHITE);
        searchBoxPanelRight.setLayout(null);
        optionButtonPanelRight = new JPanel();
        optionButtonPanelRight.setBackground(Color.WHITE);
        optionButtonPanelRight.setLayout(null); // Đặt layout là null

        gbc.weightx = 0.6;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        searchPanelRight.add(searchBoxPanelRight, gbc);
        gbc.weightx = 0.34;
        gbc.gridx = 1;
        searchPanelRight.add(optionButtonPanelRight, gbc);

        // Tạo và thêm các thành phần tìm kiếm trong searchBoxPanelLeft
        tfSearchRight = new JTextField();
        tfSearchRight.setBounds(5, 15, 270, 30);
        JButton searchButtonRight = new JButton("Tìm");
        searchButtonRight.setBounds(282, 15, 60, 30);
        searchBoxPanelRight.add(tfSearchRight);
        searchBoxPanelRight.add(searchButtonRight);

        // Tạo và thêm các nút "Tìm" và "Làm mới" trong searchButtonPanelLeft
        JButton refreshButtonRight = new JButton("Làm mới");
        refreshButtonRight.setBounds(0, 15, 85, 30);
        JButton excelButtonRight = new JButton("Xuất Excel");
        excelButtonRight.setBounds(95, 15, 90, 30);
        
        optionButtonPanelRight.add(refreshButtonRight);
        optionButtonPanelRight.add(excelButtonRight);

        // Thêm JScrollPane chứa exportTable vào exportTablePanelLeft
        JScrollPane spCTPX = new JScrollPane(exportDetailTable);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        exportTablePanelRight.add(spCTPX, gbc);
//        loadExportDetailList(exportTable);
        
        // Thiết lập bộ lắng nghe sự kiện cho hàng đã chọn trong exportTable
        exportTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    loadExportDetailList(exportTable);
                }
            }
        });
        
        searchButtonRight.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                searchButtonRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
                searchButtonRight.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                searchButtonRight.setBackground(Color.WHITE);
            }
        });
        searchButtonLeft.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                searchPerformed(exportTable);
            }
        });
        
        
        refreshButtonRight.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                refreshButtonRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
                refreshButtonRight.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                refreshButtonRight.setBackground(Color.WHITE);
            }
        });
        refreshButtonLeft.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                lamMoi();
            }
        });
        excelButtonRight.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                excelButtonRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
                excelButtonRight.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                excelButtonRight.setBackground(Color.WHITE);
            }
        });
    }

    private void loadExportList() {
        exportTable.setModel(exportModel);
        exportModel.addColumn("Mã PX");
        exportModel.addColumn("Mã người tạo");
        exportModel.addColumn("Mã kho");
        exportModel.addColumn("Mã khách hàng");
        exportModel.addColumn("Thời gian tạo");
        exportModel.addColumn("Tổng tiền");
        
        arrPX = pxBUS.getAllPhieuXuat();
        for (int i = 0; i < arrPX.size(); i++) {
            PhieuXuatDTO px = arrPX.get(i);
            String mapx = px.getMapx();
            String manguoitao = px.getManguoitao();
            String makho = px.getMakho();
            String makhachhang = px.getMakhachhang();
            Date thoigiantao = Date.valueOf(px.getThoigiantao());
            int tongtien = px.getTongtien();

            Object[] row = {mapx, manguoitao, makho, makhachhang, thoigiantao, tongtien};
            exportModel.addRow(row);
        }
    }
    
    private void loadExportDetailList(JTable tb){
        exportDetailModel.setRowCount(0);
        exportDetailModel.setColumnCount(0);
        exportDetailTable.setModel(exportDetailModel);
        exportDetailModel.addColumn("Mã PX");
        exportDetailModel.addColumn("Mã SP");
        exportDetailModel.addColumn("Tên SP");
        exportDetailModel.addColumn("Số lượng");
        exportDetailModel.addColumn("Giá");
        
        int selectedRow = exportTable.getSelectedRow();
        if(selectedRow!=-1){
            String mapx = exportTable.getValueAt(selectedRow, 0).toString();
            arrCTPX = ctpxBUS.getAllCTPhieuXuat(mapx);
            for(int i=0;i<arrCTPX.size();i++){
                CTPhieuXuatDTO ctpx = arrCTPX.get(i);
                String mactpx = ctpx.getMapx();
                String masp = ctpx.getMaSP();
                String tensp = ctpx.getTenSP();
                int soluong = ctpx.getSoLuongSP();
                int gia = ctpx.getGiaSP();
                
                Object[] row = {mapx, masp, tensp, soluong, gia};
                exportDetailModel.addRow(row);
            }
        }
    }
    
    private void searchPerformed(JTable exportTable){
        String searchContent = tfSearchLeft.getText().trim();
        if(!searchContent.isEmpty()){
            ArrayList<PhieuXuatDTO> searchList = new ArrayList<>();
            
            boolean found = false;


            for(PhieuXuatDTO px: arrPX){
                if(px.getMapx().toLowerCase().contains(searchContent.toLowerCase())||
                   px.getManguoitao().toLowerCase().contains(searchContent.toLowerCase())||
                   px.getMakho().toLowerCase().contains(searchContent.toLowerCase())||
                   px.getMakhachhang().toLowerCase().contains(searchContent.toLowerCase())||
                   px.getThoigiantao().equals(searchContent)
                   ){
                    searchList.add(px);
                    found = true;
                }
            }
            
            if(!found){
                JOptionPane.showMessageDialog(this, "Không tìm thấy phiếu xuất");
                lamMoi();
                return;
            }
            
            DefaultTableModel tableModel = (DefaultTableModel)exportTable.getModel();
            tableModel.setRowCount(0);
            
            for(PhieuXuatDTO px: searchList){
                Object[] row = {
                    px.getMapx(),
                    px.getManguoitao(),
                    px.getMakho(),
                    px.getMakhachhang(),
                    px.getThoigiantao(),
                    px.getTongtien()
                };
                tableModel.addRow(row);
            }
        } else{
            // Nếu người dùng không nhập nội dung tìm kiếm, thực hiện làm mới bảng để hiển thị tất cả sản phẩm
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm");
            lamMoi();
        }
        
    }
    
    private void lamMoi(){
        exportModel.setRowCount(0);
        exportModel.setColumnCount(0);
        loadExportList();
//        arrPX = pxBUS.get
    }
}
