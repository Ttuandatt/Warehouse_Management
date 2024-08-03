package GUI;

import java.time.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import DTO.CTPhieuNhapDTO;
import DTO.KhoHangDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import Lop.PopupKhoHang;
import Lop.PopupPhieuNhap;
import BUS.*;

public class PhieuNhapGUI extends JPanel {
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JTextArea searchTextArea;
	private JComboBox<String> searchOption;
	private JTable importTable;
	private JTextArea detailSearchTextArea;
	private JComboBox<String> detailSearchOption;
	private JTable detailTable;
	public PhieuNhapGUI() {
		this.init();
	}

	public void init() {
		this.setLayout(new GridLayout(1, 2, 10, 10));
		initLeftPanel();
		this.add(leftPanel);
		initRightPanel();
		this.add(rightPanel);

	}

	public void initLeftPanel() {
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout(10, 10));

		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
		searchTextArea = new JTextArea(2, 42);
		searchTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		InputMap inpMap = searchTextArea.getInputMap(JComponent.WHEN_FOCUSED);
		ActionMap actionMap = searchTextArea.getActionMap();
		KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		inpMap.put(enterStroke, enterStroke.toString());
		actionMap.put(enterStroke.toString(), new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!searchTextArea.getText().equals("")) {
					searchImport();
				}else {
					ArrayList<PhieuNhapDTO> listCT = new PhieuNhapBUS().getAllPhieuNhap();
					DefaultTableModel model = (DefaultTableModel) importTable.getModel();
					model.setRowCount(0);
					for (int i = 0; i < listCT.size(); i++) {
						String mapn = listCT.get(i).getMaphieu();
						String makho = listCT.get(i).getMakho();
						String mangtao = listCT.get(i).getManguoitao();
						String mancc = listCT.get(i).getMancc();
						String ngaytao = listCT.get(i).getNgaytao().toString();
						String tongtien = NumberFormat.getInstance().format(listCT.get(i).getTongTien()) + "đ";
						model.addRow(new Object[] { mapn, makho, mangtao, mancc, ngaytao, tongtien });
					}
					importTable.repaint();
				}
			}

		});
		String[] searchLabel = { "Mã phiếu", "Mã người tạo ", "Mã NCC", "Giá < value", "Giá = value",
				"Giá > value", "Ngày tạo > value", "Ngày tạo < value", "Ngày tạo = value" };
		searchOption = new JComboBox<String>(searchLabel);

		searchOption.setPreferredSize(new Dimension(120, 32));
		searchOption.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		searchOption.setSelectedIndex(0);
		searchOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!searchTextArea.getText().equals("")) {
					searchImport();
				}else {
					ArrayList<PhieuNhapDTO> listCT = new PhieuNhapBUS().getAllPhieuNhap();
					DefaultTableModel model = (DefaultTableModel) importTable.getModel();
					model.setRowCount(0);
					for (int i = 0; i < listCT.size(); i++) {
						String mapn = listCT.get(i).getMaphieu();
						String makho = listCT.get(i).getMakho();
						String mangtao = listCT.get(i).getManguoitao();
						String mancc = listCT.get(i).getMancc();
						String ngaytao = listCT.get(i).getNgaytao().toString();
						String tongtien = NumberFormat.getInstance().format(listCT.get(i).getTongtien()) + "đ";
						model.addRow(new Object[] { mapn, makho, mangtao, mancc, ngaytao, tongtien });
					}
					importTable.repaint();
				}
			}

		});
		searchPanel.add(searchTextArea);
		searchPanel.add(searchOption);

		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(1, 1));
		tablePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		ArrayList<PhieuNhapDTO> listCT = new PhieuNhapBUS().getAllPhieuNhap();
		String[] columnData = { "Mã phiếu", "Mã kho ", "Mã ngtao", "Mã ncc", "Ngày tạo", "Tổng tiền" };
		TableModel tableModel = new DefaultTableModel(columnData, 30);
		importTable = new JTable(tableModel);
		DefaultTableModel model = (DefaultTableModel) importTable.getModel();
		model.setRowCount(0);
		for (int i = 0; i < listCT.size(); i++) {
			String mapn = listCT.get(i).getMaphieu();
			String makho = listCT.get(i).getMakho();
			String mangtao = listCT.get(i).getManguoitao();
			String mancc = listCT.get(i).getMancc();
			String ngaytao = listCT.get(i).getNgaytao().toString();
			String tongtien = NumberFormat.getInstance().format(listCT.get(i).getTongtien()) + "đ";
			model.addRow(new Object[] { mapn, makho, mangtao, mancc, ngaytao, tongtien });
		}
		importTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() >= 1) {
					viewDetail();
				}
			}
		});
		importTable.repaint();
		importTable.setDefaultEditor(Object.class, null);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		TableColumnModel tableCol = importTable.getColumnModel();
		tableCol.getColumn(0).setPreferredWidth(100);
		tableCol.getColumn(1).setPreferredWidth(20);
		tableCol.getColumn(2).setPreferredWidth(20);
		tableCol.getColumn(3).setPreferredWidth(20);
		tableCol.getColumn(4).setPreferredWidth(20);
		tableCol.getColumn(5).setPreferredWidth(20);
		tableCol.getColumn(0).setCellRenderer(centerRenderer);
		tableCol.getColumn(1).setCellRenderer(centerRenderer);
		tableCol.getColumn(2).setCellRenderer(centerRenderer);
		tableCol.getColumn(3).setCellRenderer(centerRenderer);
		tableCol.getColumn(4).setCellRenderer(centerRenderer);
		tableCol.getColumn(5).setCellRenderer(centerRenderer);
		JScrollPane scrollPane = new JScrollPane(importTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVisible(true);

		tablePanel.add(scrollPane);

		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 200, 15, 200));
		btnPanel.setLayout(getLayout());

		JButton deleteButton = new JButton("Xóa");
		deleteButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				deleteImport();
			}
		});
		JButton excelButton=new JButton("Xuất Excel");
		excelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new excelExporter().excelExporterPhieuNhap();
			}
		});
		
		btnPanel.add(deleteButton);
		btnPanel.add(excelButton);
		
		leftPanel.add(searchPanel, BorderLayout.NORTH);
		leftPanel.add(tablePanel, BorderLayout.CENTER);
		leftPanel.add(btnPanel, BorderLayout.SOUTH);
	}

	public void initRightPanel() {
		rightPanel = new JPanel();

		rightPanel.setLayout(new BorderLayout());

		JPanel searchDetailPanel = new JPanel();
		searchDetailPanel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
		String[] searchDetailData = { "Mã SP", "Tên SP","Số lượng = value","Số lượng > value","Số lượng < value", "Giá = value","Giá < value","Giá > value"};
		detailSearchOption = new JComboBox<String>(searchDetailData);

		detailSearchOption.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		detailSearchOption.setPreferredSize(new Dimension(120, 36));
		detailSearchOption.setSelectedIndex(0);
		detailSearchOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel) detailTable.getModel();

				if(!detailSearchTextArea.getText().equals("")) {
					searchDetail();
				}else {
					
				}
			}

		});
		detailSearchTextArea = new JTextArea(2, 42);
		detailSearchTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		InputMap inpMap = detailSearchTextArea.getInputMap(JComponent.WHEN_FOCUSED);
		ActionMap actionMap = detailSearchTextArea.getActionMap();
		KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		inpMap.put(enterStroke, enterStroke.toString());
		actionMap.put(enterStroke.toString(), new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model= (DefaultTableModel) detailTable.getModel();

				
				if(!detailSearchTextArea.getText().equals("")) {
					searchDetail();
				}
			}

		});
		searchDetailPanel.add(detailSearchTextArea);
		searchDetailPanel.add(detailSearchOption);

		JPanel detailTablePanel = new JPanel();
		detailTablePanel.setLayout(new BorderLayout());
		detailTablePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		String[] columnData = { "Mã Phiếu", "Mã SP", "Tên SP", "Số lượng", "Tổng tiền" };
		TableModel tableModel = new DefaultTableModel(columnData, 1);
		detailTable = new JTable(tableModel);
		detailTable.setDefaultEditor(Object.class, null);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		TableColumnModel tableCol = detailTable.getColumnModel();
		tableCol.getColumn(0).setPreferredWidth(55);
		tableCol.getColumn(1).setPreferredWidth(5);
		tableCol.getColumn(2).setPreferredWidth(140);
		tableCol.getColumn(3).setPreferredWidth(5);
		tableCol.getColumn(4).setPreferredWidth(10);
		tableCol.getColumn(0).setCellRenderer(centerRenderer);
		tableCol.getColumn(1).setCellRenderer(centerRenderer);
		tableCol.getColumn(3).setCellRenderer(centerRenderer);
		tableCol.getColumn(4).setCellRenderer(centerRenderer);

		JScrollPane scrollPane = new JScrollPane(detailTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVisible(true);

		detailTablePanel.add(scrollPane, BorderLayout.CENTER);

		rightPanel.add(searchDetailPanel, BorderLayout.NORTH);
		rightPanel.add(detailTablePanel, BorderLayout.CENTER);
	}

	public void viewDetail() {

		int selectedRow = importTable.getSelectedRow();
		if (selectedRow != -1) {
			DefaultTableModel importModel = (DefaultTableModel) importTable.getModel();
			DefaultTableModel detailModel = (DefaultTableModel) detailTable.getModel();
			String ma = (String) importModel.getValueAt(selectedRow, 0);
			ArrayList<CTPhieuNhapDTO> listCT = new CTPhieuNhapBUS().getAllByID(ma);
			detailModel.setRowCount(0);
			for (int i = 0; i < listCT.size(); i++) {
				String mapn = listCT.get(i).getMapn();
				String masp = listCT.get(i).getMasp();
				String tensp = listCT.get(i).getTensp();
				String soluong = NumberFormat.getInstance().format(listCT.get(i).getSoluong());
				String tongtien = NumberFormat.getInstance().format(listCT.get(i).getGia()) + "đ";
				detailModel.addRow(new Object[] { mapn, masp, tensp, soluong, tongtien });

			}
			detailTable.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "Hãy chọn dòng cần xem chi tiết");
		}
	}

	public void deleteImport() {
		System.out.println("asd");
		int selectedRow = importTable.getSelectedRow();
		String tbao = "";
		if (selectedRow != -1) {
			DefaultTableModel model = (DefaultTableModel) importTable.getModel();
			String ma = (String) model.getValueAt(selectedRow, 0);
			ArrayList<CTPhieuNhapDTO> arr=new ArrayList<CTPhieuNhapDTO>();
			arr=new CTPhieuNhapBUS().getAllByID(ma);
			SanPhamBUS spBUS=new SanPhamBUS();
			for(int i=0;i<arr.size();i++) {
				spBUS.tangSoLuong(arr.get(i).getMasp(),-1*arr.get(i).getSoluong());
			}
			new CTPhieuNhapBUS().updateTrangThai(ma);
			tbao = new PhieuNhapBUS().delete(ma);

		} else {
			tbao = "Chọn phiếu nhập cần xóa";
		}
		JOptionPane.showMessageDialog(null, tbao);
	}

	public void searchImport() {
		DefaultTableModel model = (DefaultTableModel) importTable.getModel();

		ArrayList<PhieuNhapDTO> arr = new ArrayList<PhieuNhapDTO>();
		String option = (String) searchOption.getSelectedItem();
		String data = searchTextArea.getText();
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("Mã Phiếu", "mapn");
		condition.put("Mã người tạo", "manguoitao");
		condition.put("Mã nhà cung cấp", "mancc");
		condition.put("Giá = value", "=");
		condition.put("Giá < value", "<");
		condition.put("Giá > value", ">");
		condition.put("Ngày tạo > value", ">");
		condition.put("Ngày tạo < value", "<");
		condition.put("Ngày tạo = value", "=");
		if (option.indexOf("Mã") != -1) {

			arr = new PhieuNhapBUS().getByCondition(data, condition.get(option));
		} else if (option.indexOf("Giá") != -1) {
			if (data.matches("\\d+")==false) {
				JOptionPane.showMessageDialog(null, "Giá trị nhập vào phải là số!");
				return;
			}
			arr = new PhieuNhapBUS().getByTongTien(data, condition.get(option));
		} else {
			if (data.matches("\\d{4}-\\d{2}-\\d{2}")==false) {
				JOptionPane.showMessageDialog(null, "Giá trị nhập vào phải ở định dạng YYYY-MM-DD");
				return;
			}
			arr = new PhieuNhapBUS().getByDate(data, condition.get(option));
		}
		model.setRowCount(0);
		for (int i = 0; i < arr.size(); i++) {
			String mapn = arr.get(i).getMaphieu();
			String makho = arr.get(i).getMakho();
			String mangtao = arr.get(i).getManguoitao();
			String mancc = arr.get(i).getMancc();
			String ngaytao = arr.get(i).getNgaytao().toString();
			String tongtien = NumberFormat.getInstance().format(arr.get(i).getTongTien()) + "đ";
			model.addRow(new Object[] { mapn, makho, mangtao, mancc, ngaytao, tongtien });
		}
		importTable.repaint();
	}
	public void searchDetail() {
		DefaultTableModel model = (DefaultTableModel) detailTable.getModel();
		DefaultTableModel importModel= (DefaultTableModel) importTable.getModel();
		String ma=(String) importModel.getValueAt(importTable.getSelectedRow(), 0);
		System.out.println(ma);
		if(ma.equals("")) System.out.println(1);
		System.out.println(importTable.getSelectedRow());
		ArrayList<CTPhieuNhapDTO> arr = new ArrayList<CTPhieuNhapDTO>();
		String option = (String) detailSearchOption.getSelectedItem();
		String data = detailSearchTextArea.getText();
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("Mã Phiếu", "mapn");
		condition.put("Mã SP", "masp");
		condition.put("Tên SP", "tensp");
		condition.put("Giá = value", "=");
		condition.put("Giá < value", "<");
		condition.put("Giá > value", ">");
		condition.put("Số lượng = value", "=");
		condition.put("Số lượng < value", "<");
		condition.put("Số lượng > value", ">");
		if (option.indexOf("Giá") != -1) {
			if (data.matches("\\d+")==false) {
				JOptionPane.showMessageDialog(null, "Giá trị nhập vào phải là số!");
				return;
			}
			arr = new CTPhieuNhapBUS().getByGia(data, condition.get(option),ma);
		}else if(option.indexOf("Số")!=-1) {
			System.out.println(data.matches("\\d+"));
			if (data.matches("\\d+")==false) {
				JOptionPane.showMessageDialog(null, "Giá trị nhập vào phải là số!");
				return;
			}
			arr = new CTPhieuNhapBUS().getBySoLuong(data, condition.get(option),ma);
		} else {
			
			arr = new CTPhieuNhapBUS().getByCondition(data, condition.get(option),ma);
		}
		model.setRowCount(0);
		for (int i = 0; i < arr.size(); i++) {
			String mapn = arr.get(i).getMapn();
			String masp = arr.get(i).getMasp();
			String tensp=arr.get(i).getTensp();
			String soluong=NumberFormat.getInstance().format(arr.get(i).getSoluong());
			String tongtien = NumberFormat.getInstance().format(arr.get(i).getGia()) + "đ";
			model.addRow(new Object[] { mapn, masp,tensp,soluong,tongtien });
		}
		detailTable.repaint();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PhieuNhapGUI view = new PhieuNhapGUI();
		frame.add(view);

	}
}
