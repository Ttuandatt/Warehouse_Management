/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Lop.SanPham;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class SanPhamTableModel extends AbstractTableModel {
    private List<SanPham> data = new ArrayList<>();
    private String[] columnNames = {"Mã máy", "Tên máy", "Số lượng", "Giá", "Bộ xử lý", "Bộ nhớ", "RAM", "Nhà cung cấp"};

    public SanPhamTableModel(List<SanPham> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size(); //Có bao nhiêu đôi tượng trong List data thì là bấy nhiêu row
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;  
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SanPham sanPham = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return sanPham.getMaMay();
            case 1: return sanPham.getTenMay();
            case 2: return sanPham.getSoLuong();
            case 3: return sanPham.getGia();
            case 4: return sanPham.getBoXuLy();
            case 5: return sanPham.getBoNho();
            case 6: return sanPham.getRam();
            case 7: return sanPham.getNhaCungCap();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public void removeRow(int row) {
        SanPham sanPhamToRemove = data.get(row); // Lấy dữ liệu của dòng cần xóa
        SanPhamDAO sanPhamDAO = new SanPhamDAO(); // Khởi tạo đối tượng SanPhamDAO
        sanPhamDAO.deleteSanPham(sanPhamToRemove); // Xóa dữ liệu từ cơ sở dữ liệu
        data.remove(row); // Xóa dòng khỏi dữ liệu
        fireTableRowsDeleted(row, row); // Thông báo cho bảng biết dòng đã được xóa
    }
}
