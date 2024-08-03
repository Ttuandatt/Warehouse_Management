package GUI;
import java.time.*; 
import BUS.LoginBUS;
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
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import BUS.KhoHangBUS;
import BUS.NhaCungCapBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import DTO.CTPhieuNhapDTO;
import DTO.KhoHangDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import Lop.PopupKhoHang;
import Lop.PopupPhieuNhap;
import Lop.PopupSanPham;
import BUS.*;
public class NhapHangGUI extends JPanel{
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JTable productTable;
	private JTable importTable;
	private JLabel moneyLabel;
	private JTextField importCodeTextArea;
	 private JTextField	khoTextArea;
	private JComboBox<String> searchOption;
	private JComboBox<String> providerComboBox;
	public NhapHangGUI() {
		this.setLayout(new GridLayout(1, 2, 10, 10));
		initLeftPanel();
		this.add(leftPanel);
		initRightPanel();
		this.add(rightPanel);
		String manguoitao=new LoginBUS().getId();
		System.out.println(manguoitao);
	}
	public String generateImportCode() {
		String soluong=Integer.toString(new PhieuNhapBUS().getSoLuongPhieu()+1);
		while(soluong.length()<4) soluong="0"+soluong;
		String code="PN"+soluong;
		return code;
	}
	public void initRightPanel() {
		this.rightPanel = new JPanel();
		this.rightPanel.setLayout(new BorderLayout());
		this.rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 50));

// North
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin"));
		JPanel paddingPanel = new JPanel();
		paddingPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

		
		JPanel codePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel codeLabel = new JLabel("Mã phiếu:                    ");
		importCodeTextArea = new JTextField(15);

		importCodeTextArea.setFocusable(false);
		importCodeTextArea.setEditable(false);

		codePanel.add(codeLabel);
		codePanel.add(importCodeTextArea);
		
		JPanel khoPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel khoLabel = new JLabel("Chọn kho:                   ");
		ArrayList<KhoHangDTO> khohang=new KhoHangBUS().getAllKhoHang();
		String[] makhohang=new String[khohang.size()];
		for(int i=0;i<khohang.size();i++) {
			makhohang[i]=khohang.get(i).getMaKho();
		}
		khoTextArea=new JTextField(15);
		khoTextArea.setText(new NhanVienBUS().getMaKho(new LoginBUS().getId()));
		khoTextArea.setFocusable(false);


		khoTextArea.setEditable(false);

		khoPanel.add(khoLabel);
		khoPanel.add(khoTextArea);
		

		
		JPanel providerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ArrayList<NhaCungCapDTO> listNhaCungCap = new NhaCungCapBUS().getAllNhaCungCap();
//		providerPanel.setLayout(new BorderLayout(47, 0));
		JLabel providerLabel = new JLabel("Nhà cung cấp:          ");
		String[] providerData = new String[listNhaCungCap.size()];
		for (int i = 0; i < listNhaCungCap.size(); i++) {
			providerData[i] = listNhaCungCap.get(i).getTenNCC();
		}
		providerComboBox = new JComboBox<String>(providerData);
		providerComboBox.setBorder(BorderFactory.createEmptyBorder(7, 5, 7, 5));
		providerComboBox.setVisible(true);
		providerComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importCodeTextArea.setText(generateImportCode());
			}
		});
		providerPanel.add(providerLabel);
		providerPanel.add(providerComboBox);

		JPanel creatorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel creatorLabel = new JLabel("Người tạo:                  ");
		JTextField creatorTextArea = new JTextField(15);


		creatorTextArea.setEditable(false);
		creatorTextArea.setFocusable(false);
		creatorTextArea.setText(new LoginBUS().id);
		creatorPanel.add(creatorLabel);
		creatorPanel.add(creatorTextArea);


		infoPanel.add(codePanel);

		infoPanel.add(khoPanel);

		

		infoPanel.add(creatorPanel);
		infoPanel.add(providerPanel);
//
		importCodeTextArea.setText(generateImportCode());
//Center
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new BorderLayout());

		String[] columnData = { "Mã SP", "Tên SP", "Số lượng", "Đơn giá" };
		TableModel tableModel = new DefaultTableModel(columnData, 30);
		importTable = new JTable(tableModel);
		DefaultTableModel model = (DefaultTableModel) importTable.getModel();
		model.setRowCount(0);

		importTable.setDefaultEditor(Object.class, null);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		TableColumnModel tableCol = importTable.getColumnModel();
		tableCol.getColumn(0).setPreferredWidth(5);
		tableCol.getColumn(1).setPreferredWidth(300);
		tableCol.getColumn(2).setPreferredWidth(5);
		tableCol.getColumn(3).setPreferredWidth(50);
		tableCol.getColumn(0).setCellRenderer(centerRenderer);
		tableCol.getColumn(2).setCellRenderer(centerRenderer);
		tableCol.getColumn(3).setCellRenderer(centerRenderer);
		JScrollPane scrollPane = new JScrollPane(importTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVisible(true);

		JPanel optionPanel = new JPanel();
		JButton quantityButton = new JButton("Sửa số lượng");
		quantityButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeQuantity(quantityButton, importTable);
				importTable.clearSelection();
			}
		});
		JButton deleteButton = new JButton("Xóa sản phẩm");
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteProductImported(importTable);
			}
		});
		optionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionPanel.add(quantityButton);
		optionPanel.add(deleteButton);

		tempPanel.add(scrollPane, BorderLayout.CENTER);
		tempPanel.add(optionPanel, BorderLayout.SOUTH);

//

// South
		JPanel summaryPanel = new JPanel();
		summaryPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
		JLabel totalLabel = new JLabel("Tổng Tiền:");
		moneyLabel = new JLabel("0đ");
		JButton importButton = new JButton("Nhập hàng");
		importButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSoLuong(importTable);
			}
		});
		summaryPanel.add(totalLabel);
		summaryPanel.add(moneyLabel);
		summaryPanel.add(importButton);
//		

		this.rightPanel.add(infoPanel, BorderLayout.NORTH);
		this.rightPanel.add(tempPanel, BorderLayout.CENTER);
		this.rightPanel.add(summaryPanel, BorderLayout.SOUTH);
	}

	public void changeQuantity(JButton btn, JTable table) {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm thay đổi số lượng");
		} else {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String productCodeString = (String) model.getValueAt(selectedRow, 0);
			String newQuantity = JOptionPane.showInputDialog("Vui lòng nhập số lượng cho mã " + productCodeString);
			if (newQuantity.equals("") || newQuantity.matches("%[a-zA-Z]%") || newQuantity.equals("0")) {
				JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ");
				return;
			} else {
				String masp = (String) model.getValueAt(selectedRow, 0);
				String tensp = (String) model.getValueAt(selectedRow, 1);
				String dongia = (String) model.getValueAt(selectedRow, 3);
				model.setValueAt(table, selectedRow, selectedRow);
				dongia = dongia.replaceAll("\\,", "");
				dongia = dongia.replaceFirst("đ", "");
				int soluong = Integer.parseInt((String) model.getValueAt(selectedRow, 2));
				int val = Integer.parseInt(dongia) / soluong;
				int soluongmoi = Integer.parseInt(newQuantity);
				model.setValueAt(masp, selectedRow, 0);
				model.setValueAt(tensp, selectedRow, 1);
				model.setValueAt(Integer.toString(soluongmoi), selectedRow, 2);
				model.setValueAt(NumberFormat.getInstance().format(val * soluongmoi)+"đ", selectedRow, 3);

				String oldMoney = moneyLabel.getText();
				oldMoney = oldMoney.replaceAll("\\,", "");
				oldMoney = oldMoney.replaceFirst("đ", "");
				int oldMoneyInt = Integer.parseInt(oldMoney);
				int newMoney = oldMoneyInt - Integer.parseInt(dongia) + (val * soluongmoi);
				moneyLabel.setText(NumberFormat.getInstance().format(newMoney) + "đ");
			}
		}
	}

	public void initLeftPanel() {

		this.leftPanel = new JPanel();
		this.leftPanel.setLayout(new BorderLayout());
		this.leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));



		JPanel productPanel = new JPanel();
		productPanel.setLayout(new GridLayout(1, 1));
		productPanel.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm"));
		ArrayList<SanPhamDTO> listSanPham = new SanPhamBUS().getAllSanPham();

		String[] columnData = { "Mã SP", "Tên SP", "Số lượng", "Đơn giá" };
		TableModel tableModel = new DefaultTableModel(columnData, 30);
		productTable = new JTable(tableModel);
		DefaultTableModel model = (DefaultTableModel) productTable.getModel();
		model.setRowCount(0);
		for (int i = 0; i < listSanPham.size() ; i++) {

			String masp = listSanPham.get(i).getMaMay();
			if (masp == " ")
				continue;
			String tensp = listSanPham.get(i).getTenMay();
			String soluong = Integer.toString(listSanPham.get(i).getSoLuong());
			String dongia = NumberFormat.getInstance().format(listSanPham.get(i).getGia()) + "đ";
			model.addRow(new Object[] { masp, tensp, soluong, dongia });
		}
		productTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() >= 2) {

					int selectedRow = productTable.getSelectedRow();
					String masp = (String) productTable.getValueAt(selectedRow, 0);
					PopupPhieuNhap popup = new PopupPhieuNhap(new SanPhamBUS().getSanPhamByMaSP(masp));
					productTable.clearSelection();
				}

			}
		});
		productTable.repaint();
		productTable.setDefaultEditor(Object.class, null);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
		JTextArea searchTextArea = new JTextArea(2, 42);
		InputMap inpMap = searchTextArea.getInputMap(JComponent.WHEN_FOCUSED);
		ActionMap actionMap = searchTextArea.getActionMap();
		KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		inpMap.put(enterStroke, enterStroke.toString());
		actionMap.put(enterStroke.toString(), new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (searchTextArea.equals("")) {
					model.setRowCount(0);
					ArrayList<SanPhamDTO> listSanPham = new SanPhamBUS().getAllSanPham();
					for (int i = 0; i < listSanPham.size() - 1; i++) {

						String masp = listSanPham.get(i).getMaMay();
						if (masp == " ")
							continue;
						String tensp = listSanPham.get(i).getTenMay();
						String soluong = Integer.toString(listSanPham.get(i).getSoLuong());
						String dongia = NumberFormat.getInstance().format(listSanPham.get(i).getGia()) + "đ";
						model.addRow(new Object[] { masp, tensp, soluong, dongia });
					}
				} else {
					
					String condition = (String) searchOption.getSelectedItem();
					String dataCondition = searchTextArea.getText();
					Map<String, String> optionMap=new HashMap<String,String>();
					optionMap.put("Mã sp", "masp");
					optionMap.put("Tên sp","tensp");
					optionMap.put("Giá > value",">");
					optionMap.put("Giá < value","<");
					optionMap.put("Giá = value","=");
					ArrayList<SanPhamDTO> listSP ;
					if(condition.equals("Giá > value")||condition.equals("Giá < value")||condition.equals("Giá = value" )){
						if(!(dataCondition.matches("-?\\d+(\\,\\d+)?"))) {
							searchTextArea.setText("");
							JOptionPane.showMessageDialog(null,"Giá trị trong ô tìm phải là số");
							return;
						}
						condition=optionMap.get(condition);
	
						listSP = new SanPhamBUS().getSanPhamByGia(Integer.parseInt(dataCondition),
								condition);

				

					}else {
						condition=optionMap.get(condition);
						 listSP = new SanPhamBUS().getSanPhamByCondition(condition,
								dataCondition);

					}

					model.setRowCount(0);
					for (int i = 0; i < listSP.size() - 1; i++) {

						String masp = listSP.get(i).getMaMay();
						if (masp == " ")
							continue;
						String tensp = listSP.get(i).getTenMay();
						String soluong = Integer.toString(listSP.get(i).getSoLuong());
						String dongia = NumberFormat.getInstance().format(listSP.get(i).getGia()) + "đ";
						model.addRow(new Object[] { masp, tensp, soluong, dongia });

					}
	
				}

			}
		});

		searchTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

		String[] searchLabel = { "Mã sp", "Tên sp","Giá > value","Giá < value","Giá = value" };
		searchOption = new JComboBox<String>(searchLabel);

		searchOption.setPreferredSize(new Dimension(80, 32));
		searchOption.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		searchOption.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				if (searchTextArea.equals("")) {
					model.setRowCount(0);
					ArrayList<SanPhamDTO> listSanPham = new SanPhamBUS().getAllSanPham();
					for (int i = 0; i < listSanPham.size() - 1; i++) {

						String masp = listSanPham.get(i).getMaMay();
						if (masp == " ")
							continue;
						String tensp = listSanPham.get(i).getTenMay();
						String soluong = Integer.toString(listSanPham.get(i).getSoLuong());
						String dongia = NumberFormat.getInstance().format(listSanPham.get(i).getGia()) + "đ";
						model.addRow(new Object[] { masp, tensp, soluong, dongia });
					}
				} else {

					String condition = (String) searchOption.getSelectedItem();
					String dataCondition = searchTextArea.getText();
					Map<String, String> optionMap=new HashMap<String,String>();
					optionMap.put("Mã sp", "masp");
					optionMap.put("Tên sp","tensp");
					optionMap.put("Giá > value",">");
					optionMap.put("Giá < value","<");
					optionMap.put("Giá = value","=");
					ArrayList<SanPhamDTO> listSP ;
					if(condition.equals("Giá > value")||condition.equals("Giá < value")||condition.equals("Giá = value" )){
						if(!(dataCondition.matches("-?\\d+(\\,\\d+)?"))) {
							searchTextArea.setText("");
							JOptionPane.showMessageDialog(null,"Giá trị trong ô tìm phải là số");
							return;
						}
						condition=optionMap.get(condition);
	
						listSP = new SanPhamBUS().getSanPhamByGia(Integer.parseInt(dataCondition),
								condition);

				

					}else {
						condition=optionMap.get(condition);
						 listSP = new SanPhamBUS().getSanPhamByCondition(condition,
								dataCondition);

					}

					model.setRowCount(0);
					for (int i = 0; i < listSP.size() - 1; i++) {

						String masp = listSP.get(i).getMaMay();
						if (masp == " ")
							continue;
						String tensp = listSP.get(i).getTenMay();
						String soluong = Integer.toString(listSP.get(i).getSoLuong());
						String dongia = NumberFormat.getInstance().format(listSP.get(i).getGia()) + "đ";
						model.addRow(new Object[] { masp, tensp, soluong, dongia });

					}
	
				}
				
			}
		});
		searchPanel.add(searchTextArea);
		searchPanel.add(searchOption);
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		TableColumnModel tableCol = productTable.getColumnModel();
		tableCol.getColumn(0).setPreferredWidth(5);
		tableCol.getColumn(1).setPreferredWidth(300);
		tableCol.getColumn(2).setPreferredWidth(5);
		tableCol.getColumn(3).setPreferredWidth(5);
		tableCol.getColumn(0).setCellRenderer(centerRenderer);
		tableCol.getColumn(2).setCellRenderer(centerRenderer);
		tableCol.getColumn(3).setCellRenderer(centerRenderer);
		JScrollPane scrollPane = new JScrollPane(productTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVisible(true);
		productPanel.add(scrollPane);

		JPanel optionPanel = new JPanel();
		optionPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 15, 5));

		JLabel quantityLabel = new JLabel("Số lượng nhập:");
		quantityLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		JTextArea quantityTextArea = new JTextArea(1, 15);
		quantityTextArea.setText("");
		quantityTextArea.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		InputMap quantityInpMap = quantityTextArea.getInputMap(JComponent.WHEN_FOCUSED);
		ActionMap quantityActionMap = quantityTextArea.getActionMap();
		KeyStroke enterStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		quantityInpMap.put(enterStroke1, enterStroke1.toString());
		quantityActionMap.put(enterStroke1.toString(), new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				addToImportTable(productTable, importTable, quantityTextArea);
				productTable.clearSelection();
			}
			
		});
		JLabel whitespaceLabel = new JLabel(" ");
		whitespaceLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		JButton addQuantityButton = new JButton("Thêm số lượng");
		addQuantityButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				addToImportTable(productTable, importTable, quantityTextArea);
				productTable.clearSelection();
			}
		});
		
		JButton addNewButton= new JButton("Thêm mới");
		addNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new PopupSanPham("Thêm sản phẩm mới","Thêm sản phẩm", "add");
			}
		});
		changeColorOnHover(addQuantityButton);

		optionPanel.add(quantityLabel);
		optionPanel.add(quantityTextArea);
		optionPanel.add(whitespaceLabel);
		optionPanel.add(addQuantityButton);
		optionPanel.add(addNewButton);

		
		leftPanel.add(searchPanel, BorderLayout.NORTH);
		leftPanel.add(productPanel, BorderLayout.CENTER);
		leftPanel.add(optionPanel, BorderLayout.SOUTH);
	}

	public void changeColorOnHover(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
//			btn.setBackground(Color.decode("#15F5BA"));
//			btn.setForeground(Color.decode("#F0F3FF"));
//			btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
//			btn.setBackground(Color.decode("#15F5BA"));
//			btn.setForeground(Color.decode("#F0F3FF"));
			}
		});
	}

	public void addToImportTable(JTable table, JTable importTable, JTextArea quantity) {
		int selectedRow = table.getSelectedRow();
		System.out.println((String)providerComboBox.getSelectedItem());
		if (quantity.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số lượng không được để trống");
			return;
		} else if (selectedRow != -1 && Integer.parseInt(quantity.getText()) > 0) {
			DefaultTableModel model = (DefaultTableModel) importTable.getModel();
			String giasp = (String) table.getModel().getValueAt(selectedRow, 3);
			giasp = giasp.replaceAll("\\,", "");
			giasp = giasp.replaceFirst("đ", "");
			giasp = giasp.substring(0, giasp.length());

			Vector<String> data = new Vector<String>();
			String masp = (String) table.getModel().getValueAt(selectedRow, 0);
			boolean isDup = false;
			for (int i = 0; i < model.getRowCount(); i++) {
				String ma = (String) model.getValueAt(i, 0);
				if (ma.equals(masp)) {
					isDup = true;
					String oldValue = (String) model.getValueAt(i, 3);
					oldValue = oldValue.replaceAll("\\,", "");
					oldValue = oldValue.replaceFirst("đ", "");
					int newQuantity = Integer.parseInt(quantity.getText())
							+ Integer.parseInt((String) model.getValueAt(i, 2));
					String soluong = Integer.toString(newQuantity);

					int value = newQuantity * Integer.parseInt(giasp);
					String dongia = NumberFormat.getInstance().format(value) + "đ";
					model.setValueAt(soluong, i, 2);
					model.setValueAt(dongia, i, 3);

					String money = moneyLabel.getText();
					money = money.substring(0, money.length() - 1);
					money = money.replaceAll("\\,", "");

					moneyLabel.setText(NumberFormat.getInstance()
							.format(Integer.parseInt(money) - Integer.parseInt(oldValue) + value) + "đ");
					quantity.setText("");
					importCodeTextArea.setText(ma);
					break;
				}
			}
			if (!isDup) {
				int value = Integer.parseInt(quantity.getText()) * Integer.parseInt(giasp);
				String tensp = (String) table.getModel().getValueAt(selectedRow, 1);
				String soluong = quantity.getText();
				String dongia = NumberFormat.getInstance().format(value) + "đ";
				data.add(masp);
				data.add(tensp);
				data.add(dongia);

				model.addRow(new Object[] { masp, tensp, soluong, dongia });
				quantity.setText("");
				importTable.repaint();
				String money = moneyLabel.getText();

				money = money.substring(0, money.length() - 1);
				money = money.replaceAll("\\,", "");
				moneyLabel.setText(NumberFormat.getInstance().format(Integer.parseInt(money) + value) + "đ");

			}
		} else if (Integer.parseInt(quantity.getText()) <= 0) {
			JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0");
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần sửa");
		}

	}

	public void updateSoLuong(JTable table) {
		SanPhamBUS spBus = new SanPhamBUS();
		PhieuNhapBUS pnBUS=new PhieuNhapBUS();
		CTPhieuNhapBUS ctphieunhapBUS=new CTPhieuNhapBUS();
		
		DefaultTableModel model = (DefaultTableModel) importTable.getModel();
		String tbao = "";
		for (int i = 0; i < table.getRowCount(); i++) {
			String masp = (String) table.getValueAt(i, 0);
			String mapn= importCodeTextArea.getText();
			String tensp=(String) table.getValueAt(i, 1);
			int soluong = Integer.parseInt((String) table.getValueAt(i, 2));
			String tien=(String) table.getValueAt(i, 3);
			tien=tien.substring(0,tien.length()-1);
			tien=tien.replaceAll("\\,", "");
			int tongtien=Integer.parseInt(tien);
			ctphieunhapBUS.add(new CTPhieuNhapDTO(mapn,masp,tensp,soluong,tongtien));
			tbao = spBus.tangSoLuong(masp, soluong);
		}
		model.setRowCount(0);
		if (tbao.equals("Tăng số lượng thành công")) {

			String mapn= importCodeTextArea.getText();
			String mancc= new NhaCungCapBUS().getByName((String)providerComboBox.getSelectedItem()).getMaNCC();
			String manguoitao=new LoginBUS().getId();

			String makho=new NhanVienBUS().getMaKho(new LoginBUS().getId());
			String money = moneyLabel.getText();
			LocalDate current=LocalDate.now();
			money = money.substring(0, money.length() - 1);
			money = money.replaceAll("\\,", "");
			int tongtien=Integer.parseInt(money);
			pnBUS.add(new PhieuNhapDTO(mapn,mancc,manguoitao,makho, current,tongtien,1));
			table.repaint();
			moneyLabel.setText("0đ");
			DefaultTableModel modelProduct = (DefaultTableModel) productTable.getModel();
			modelProduct.setRowCount(0);
			ArrayList<SanPhamDTO> listSanPham = new SanPhamBUS().getAllSanPham();
			for (int i = 0; i < listSanPham.size() - 1; i++) {

				String masp = listSanPham.get(i).getMaMay();
				if (masp == " ")
					continue;
				String tensp = listSanPham.get(i).getTenMay();
				String soluong = Integer.toString(listSanPham.get(i).getSoLuong());
				String dongia = Integer.toString(listSanPham.get(i).getGia());

				modelProduct.addRow(new Object[] { masp, tensp, soluong, dongia });
			}

			productTable.repaint();
			importCodeTextArea.setText(generateImportCode());
		JOptionPane.showMessageDialog(null, tbao);
		} else {
			JOptionPane.showMessageDialog(null, "Không có sản phẩm trong bảng nhập hàng");
		}

	}

	public void deleteProductImported(JTable table) {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần xóa");
		} else {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String dongia = (String) model.getValueAt(selectedRow, 3);
			dongia = dongia.replaceAll("\\,", "");
			dongia = dongia.replaceFirst("đ", "");
			String oldMoney = moneyLabel.getText();
			oldMoney = oldMoney.replaceAll("\\,", "");
			oldMoney = oldMoney.replaceFirst("đ", "");
			int val = Integer.parseInt(oldMoney);
			val = val - Integer.parseInt(dongia);
			moneyLabel.setText(NumberFormat.getInstance().format(val) + "đ");
			model.removeRow(selectedRow);
			table.repaint();
		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		NhapHangGUI view = new NhapHangGUI();
		frame.add(view);

	}
}
