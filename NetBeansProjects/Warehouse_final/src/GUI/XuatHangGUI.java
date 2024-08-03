package GUI;
import BUS.SanPhamBUS;
import BUS.LoginBUS;
import BUS.PhieuXuatBUS;
import BUS.CTPhieuXuatBUS;
import DTO.CTPhieuXuatDTO;
import DTO.SanPhamDTO;
import DTO.PhieuXuatDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.time.LocalDate;

public class XuatHangGUI extends JPanel {
    private int totalPrice = 0;
    private JTextField tfMaPX, tfNguoiTao, tfKhachHang, tfKho, tfSoLuong, tfTimKiem;
    private int countAddRow = 0;
    public JLabel moneyLabel;
    private JPanel rightPanel;
    private SanPhamBUS spBUS = new SanPhamBUS();
    private PhieuXuatBUS pxBUS = new PhieuXuatBUS();
    private CTPhieuXuatBUS ctpxBUS = new CTPhieuXuatBUS();
    private JTable table = new JTable();
    private JTable table1 = new JTable();
    private ArrayList<SanPhamDTO> arrSanPham = new ArrayList<>();
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel model1 = new DefaultTableModel();
    private JPanel leftPanel;


    public XuatHangGUI() {
        this.setLayout(new GridLayout(1, 2, 10, 10));
        initLeftPanel();
        this.add(leftPanel);
        initRightPanel();
        this.add(rightPanel);
    }



    public void initLeftPanel() {
    table.setDefaultEditor(Object.class, null);
    leftPanel = new JPanel();
    leftPanel.setLayout(new BorderLayout());
    leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));

    // Panel tìm kiếm
    JPanel searchPanel = new JPanel(new BorderLayout());
    searchPanel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));

    // Text field tìm kiếm
    tfTimKiem = new JTextField();
    // Nút tìm kiếm
    JButton searchButton = new JButton("Tìm");
    
    // Nút làm mới
    JButton refreshButton = new JButton("Làm mới");
    
    // Thêm text field, nút tìm kiếm và nút làm mới vào searchPanel
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    buttonPanel.add(searchButton);
    buttonPanel.add(refreshButton);
    
    searchPanel.add(tfTimKiem, BorderLayout.CENTER);
    searchPanel.add(buttonPanel, BorderLayout.EAST);

    // Panel danh sách sản phẩm
    JPanel productPanel = new JPanel(new BorderLayout());
    productPanel.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm"));

    // Tạo DefaultTableModel
    table.setModel(model);
    JScrollPane scrollPane = new JScrollPane(table);
    productPanel.add(scrollPane, BorderLayout.CENTER);

    // Panel lựa chọn sản phẩm
    JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lbSoLuong = new JLabel("Số lượng:");
    tfSoLuong = new JTextField(5);
    JButton addButton = new JButton("Thêm");
    optionPanel.add(lbSoLuong);
    optionPanel.add(tfSoLuong);
    optionPanel.add(addButton);

    // Thêm các panel vào leftPanel
    leftPanel.add(searchPanel, BorderLayout.NORTH);
    leftPanel.add(productPanel, BorderLayout.CENTER);
    leftPanel.add(optionPanel, BorderLayout.SOUTH);

    // Load dữ liệu vào bảng sản phẩm
    loadSanPhamList();

    // Sự kiện cho nút thêm
    addButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e){
            addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            addButton.setBackground(Color.decode("#D6D6D6"));
        }
        @Override
        public void mouseExited(MouseEvent e){
            addButton.setBackground(Color.WHITE);
        }
    });
    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRowIndex = table.getSelectedRow();
            if (selectedRowIndex != -1) {
                String soLuongText = tfSoLuong.getText();
                if (soLuongText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng");
                } else {
                    String maSP = table.getValueAt(selectedRowIndex, 0).toString();
                    String tenSP = table.getValueAt(selectedRowIndex, 1).toString();
                    int soLuong = Integer.parseInt(tfSoLuong.getText());
                    int donGia = Integer.parseInt(table.getValueAt(selectedRowIndex, 3).toString()); //.getValueAt trả về một đối tượng kiểu Object, sau đó ép về String, sau đó ép về int

                    // Kiểm tra xem sản phẩm đã có trong bảng tempTable chưa
                    boolean productExists = false;
                    for (int i = 0; i < model1.getRowCount(); i++) {
                        if (maSP.equals(model1.getValueAt(i, 1).toString())) {
                            // Sản phẩm đã tồn tại, tăng số lượng
                            int currentQuantity = Integer.parseInt(model1.getValueAt(i, 3).toString());
                            model1.setValueAt(currentQuantity + soLuong, i, 3);
                            productExists = true;
                            break;
                        }
                    }

                    if (!productExists) {
                        // Sản phẩm chưa tồn tại, thêm hàng mới
                        int newIndex = model1.getRowCount() + 1;
                        Object[] newRow = {String.valueOf(newIndex), maSP, tenSP, soLuong, donGia};
                        model1.addRow(newRow);
                        countAddRow += 1;
                    }

                    // Tính toán giá
                    int price = 0;
                    price += donGia * soLuong;
                    totalPrice += price;

                    moneyLabel.setText(String.format("%d đ", totalPrice)); 
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm");
            }
        }
    });

    // Sự kiện cho nút tìm kiếm
    searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            search(table);
        }
    });
    searchButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                searchButton.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                searchButton.setBackground(Color.WHITE);
            }
    });

    // Sự kiện cho nút làm mới
    refreshButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Làm mới bảng sản phẩm
            lamMoi();

        }
    });
    refreshButton.addMouseListener(new MouseAdapter(){
        @Override
            public void mouseEntered(MouseEvent e){
                refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                refreshButton.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                refreshButton.setBackground(Color.WHITE);
            }
    });
}




    public void initRightPanel() {
        table1.setDefaultEditor(Object.class,null);
        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 50));

        // North
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin"));

        JPanel codePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel codeLabel = new JLabel("Mã phiếu:        ");
        tfMaPX = new JTextField(15);
        tfMaPX.setEditable(false);
        tfMaPX.setFocusable(false);
        codePanel.add(codeLabel);
        codePanel.add(tfMaPX);
        PhieuXuatDTO pxDTO = new PhieuXuatDTO();
        tfMaPX.setText(generateExportCode());


        JPanel creatorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel creatorLabel = new JLabel("Mã người tạo: ");
        tfNguoiTao = new JTextField(15);
        tfNguoiTao.setEditable(false);
        tfNguoiTao.setFocusable(false);
        creatorPanel.add(creatorLabel);
        creatorPanel.add(tfNguoiTao);
        tfNguoiTao.setText(LoginBUS.id);
        
        JPanel warehousePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel warehouseLabel = new JLabel("Mã Kho:           ");
        tfKho = new JTextField(15);
        tfKho.setText(LoginBUS.makho);
        warehousePanel.add(warehouseLabel);
        warehousePanel.add(tfKho);
        tfKho.setFocusable(false);
        tfKho.setEditable(false);
        
        JPanel customerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel customerLabel = new JLabel("Mã KH:            ");
        tfKhachHang = new JTextField(15);
        tfKhachHang.setText("/");
        customerPanel.add(customerLabel);
        customerPanel.add(tfKhachHang);
        
        
        
        infoPanel.add(codePanel);
        infoPanel.add(creatorPanel);
        infoPanel.add(warehousePanel);
        infoPanel.add(customerPanel);

        // Center
        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new BorderLayout());
        String[][] tableData = {};
        String[] columnData = {"STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá"};
        model1 = new DefaultTableModel(tableData, columnData); // Assign to the class field
        table1.setModel(model1);
        JScrollPane scrollPane = new JScrollPane(table1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVisible(true);

        JPanel optionPanel = new JPanel();
        JButton editQuantityButton = new JButton("Sửa số lượng");
        JButton deleteButton = new JButton("Xóa sản phẩm");
        JButton buttonXuatExcel = new JButton("Xuất excel");
        optionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionPanel.add(editQuantityButton);
        optionPanel.add(deleteButton);
        optionPanel.add(buttonXuatExcel);
        
        tempPanel.add(scrollPane, BorderLayout.CENTER);
        tempPanel.add(optionPanel, BorderLayout.SOUTH);

        // South
        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        JLabel totalLabel = new JLabel("Tổng tiền:");
        moneyLabel = new JLabel("đ");
        JButton exportButton = new JButton("Xuất hàng");
        summaryPanel.add(totalLabel);
        summaryPanel.add(moneyLabel);
        summaryPanel.add(exportButton);

        this.rightPanel.add(infoPanel, BorderLayout.NORTH);
        this.rightPanel.add(tempPanel, BorderLayout.CENTER);
        this.rightPanel.add(summaryPanel, BorderLayout.SOUTH);
        
        exportButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                exportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                exportButton.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                exportButton.setBackground(Color.WHITE);
            }
        });
        exportButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                xuatHangPerformed(table1);
            }
        });
        
        deleteButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                deleteButton.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                deleteButton.setBackground(Color.WHITE);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowIndex = table1.getSelectedRow();
                int soLuong = Integer.parseInt(table1.getValueAt(selectedRowIndex, 3).toString());
                int gia = Integer.parseInt(table1.getValueAt(selectedRowIndex, 4).toString());
                if (selectedRowIndex != -1) {
                    model1.removeRow(selectedRowIndex);
                    // Update the total price after removing the row
                    totalPrice -= gia*soLuong;
                    moneyLabel.setText(String.format("%d đ", totalPrice)); 
                }   
            }
        });
        
        editQuantityButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                editQuantityButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                editQuantityButton.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                editQuantityButton.setBackground(Color.WHITE);
            }
        });

        editQuantityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowIndex = table1.getSelectedRow();
                if (selectedRowIndex != -1) {
                    // Get the current quantity from the selected row
                    String currentQuantity = model1.getValueAt(selectedRowIndex, 3).toString();
                    
                    // Prompt the user to enter the new quantity
                    String newQuantityStr = JOptionPane.showInputDialog(null, "Enter new quantity:", currentQuantity);
                    
                    // If the user entered a new quantity
                    if (newQuantityStr != null && !newQuantityStr.isEmpty()) {
                        int soLuongHienTai = Integer.parseInt(currentQuantity);
                        int soLuongMoi = Integer.parseInt(newQuantityStr);
                        // Update the quantity in the table model
                        model1.setValueAt(soLuongMoi, selectedRowIndex, 3);
                        String donGiaStr = model1.getValueAt(selectedRowIndex, 4).toString();
                        int donGia = Integer.parseInt(donGiaStr);
                        totalPrice -= donGia*soLuongHienTai;
                        totalPrice += donGia*soLuongMoi;

                        moneyLabel.setText(String.format("%d", totalPrice)); 
                    }
                }
            }
        });
        
       
        buttonXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excelExporter ex = new excelExporter();
                ex.excelExporterPhieuXuat();
                JOptionPane.showMessageDialog(null, "Excel file exported successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonXuatExcel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonXuatExcel.setBackground(Color.decode("#D6D6D6"));
                buttonXuatExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                buttonXuatExcel.setBackground(Color.WHITE);
            }
        });
        
    }

    public void loadSanPhamList() {
        table.setModel(model);
        model.addColumn("Mã máy");
        model.addColumn("Tên máy");
        model.addColumn("Số lượng");
        model.addColumn("Giá");
        model.addColumn("Kho");
        arrSanPham = spBUS.getAllSanPham(); // Get data from the database
        for (SanPhamDTO sanpham : arrSanPham) {
            String mamay = sanpham.getMaMay();
            String tenmay = sanpham.getTenMay();
            int soluong = sanpham.getSoLuong();
            int gia = sanpham.getGia();
            String kho = sanpham.getMaKho();
            Object[] row = {mamay, tenmay, soluong , gia, kho};
            model.addRow(row);
        }
    }
    
    public void search(JTable tb) {
        String searchContent = tfTimKiem.getText().trim();
        if(!searchContent.isEmpty()){
            ArrayList<SanPhamDTO> dsTimKiem = new ArrayList<>();
            
            boolean found = false;
            for(SanPhamDTO sanPham: arrSanPham){
                // Kiểm tra xem thông tin của sản phẩm có chứa chuỗi tìm kiếm hay không (sử dụng phương thức contains)
                if (sanPham.getMaMay().toLowerCase().contains(searchContent.toLowerCase()) ||
                    sanPham.getTenMay().toLowerCase().contains(searchContent.toLowerCase())||
                    sanPham.getBoNho().toLowerCase().contains(searchContent.toLowerCase()) ||
                    sanPham.getBoXuLy().toLowerCase().contains(searchContent.toLowerCase())||
                    sanPham.getGPU().toLowerCase().contains(searchContent.toLowerCase())   ||
                    sanPham.getNhaCungCap().toLowerCase().contains(searchContent.toLowerCase())||
                    sanPham.getRam().toLowerCase().contains(searchContent.toLowerCase())||
                    sanPham.getMaKho().toLowerCase().contains(searchContent.toLowerCase())
                ){
                    dsTimKiem.add(sanPham);
                    found = true;
                }
            }
            
            if(!found){
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
                lamMoi();
                return; // Kết thúc phương thức sau khi hiển thị thông báo
            }
            
            DefaultTableModel tableModel = (DefaultTableModel)tb.getModel();
            tableModel.setRowCount(0);
            
            for(SanPhamDTO sanPham: dsTimKiem){
                Object[] row = {
                    sanPham.getMaMay(),
                    sanPham.getTenMay(),
                    sanPham.getSoLuong(),
                    sanPham.getGia(),
//                    sanPham.getBoXuLy(),
//                    sanPham.getBoNho(),
//                    sanPham.getRam(),
//                    sanPham.getGPU(),
                    sanPham.getMaKho()
                };
                tableModel.addRow(row);
            }
        }else{
            // Nếu người dùng không nhập nội dung tìm kiếm, thực hiện làm mới bảng để hiển thị tất cả sản phẩm
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm");
            lamMoi();
        }
//        // If the search text is empty, reset the table to display all data
//        if (searchText.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm");
//        }
//
//        // Otherwise, filter the data based on the search text
//        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
//        productTable.setRowSorter(sorter);
//
//        // Define the filter
//        RowFilter<TableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText); // Case insensitive filter
//
//        // Apply the filter to the sorter
//        sorter.setRowFilter(rowFilter);
    }

    private void xuatHangPerformed(JTable tb){
            int dialogResult = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xuất hàng?");
            if(dialogResult == JOptionPane.OK_OPTION){
                // Lấy mã phiếu xuất, mã người tạo, mã khách hàng và tổng tiền từ giao diện
                String mapx = tfMaPX.getText(); 
                String maNguoiTao = tfNguoiTao.getText();
                String makho = tfKho.getText();
                String makhachhang = tfKhachHang.getText();
                LocalDate currentTime = LocalDate.now();
                LocalDate tgiantao = Date.valueOf(currentTime).toLocalDate(); // Lấy thời gian hiện tại và tạo một đối tượng Timestamp
                System.out.println(tgiantao);
                int tongtien = totalPrice;                
                
                // Tạo một đối tượng DTO cho phiếu nhập
                PhieuXuatDTO pxDTO = new PhieuXuatDTO(mapx, maNguoiTao, makho, makhachhang, tgiantao, tongtien);
                // Gọi phương thức thêm phiếu nhập vào cơ sở dữ liệu
                String resultPX = pxBUS.addPhieuXuat(pxDTO);
                String resultCTPX = "";
                for(int i=0;i<countAddRow;i++){
                    String masp = table1.getValueAt(i, 1).toString();
                    String tensp = table1.getValueAt(i, 2).toString();
                    int soluong = Integer.parseInt(table1.getValueAt(i, 3).toString());
                    int gia = Integer.parseInt(table1.getValueAt(i, 4).toString());
                    CTPhieuXuatDTO ctpxDTO = new CTPhieuXuatDTO(mapx,masp, tensp, soluong, gia);
                    resultCTPX = ctpxBUS.addCTPhieuXuat(ctpxDTO);
                }
                System.out.println(countAddRow);
                System.out.println(pxDTO);
                
//                
                
                
                // Xử lý kết quả và thông báo cho người dùng
                if (resultPX.equals("Thêm px thành công") && resultCTPX.equals("Thêm chi tiết phiếu xuất thành công")) {
                    JOptionPane.showMessageDialog(null, "Xuất hàng thành công!");
                    // Có thể reset giao diện hoặc cập nhật lại giao diện nếu cần
                } else {
                    JOptionPane.showMessageDialog(null, "Xuất hàng thất bại: " + resultPX);
                }
            }
            
    }
    
    private String generateExportCode(){
        int currentCount = pxBUS.countPhieuXuat();
        int newCount = currentCount + 1;
        String newMaPX = "PX" + newCount;
        return newMaPX;
    }
    
    private void lamMoi(){
        model.setRowCount(0);
        model.setColumnCount(0);
        
        loadSanPhamList();
        
        tfTimKiem.setText("");
        tfSoLuong.setText("");
        
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Xuat Hang Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        XuatHangGUI view = new XuatHangGUI();
        frame.add(view);
        frame.setVisible(true);
    }
}


