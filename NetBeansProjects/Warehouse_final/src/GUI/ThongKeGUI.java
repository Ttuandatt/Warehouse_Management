package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import DAO.*;
import DTO.*;
import BUS.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.util.Rotation;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class ThongKeGUI extends JPanel {
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private ChartPanel importChartPanel;
	private ChartPanel exportChartPanel;
	private JComboBox<String> optionComboBox;
	private JTextArea startTextArea;
	private JTextArea endTextArea;
	private JTable importTable;
	private JTable exportTable;
	private JScrollPane importScrollPane;
	private JScrollPane exportScrollPane;
	private JPanel tablePanel;
	private JComboBox<String> khoComboBox;

	public ThongKeGUI() {
		this.setLayout(new GridLayout(1, 2));
		initLeftPanel();
		this.add(leftPanel, BorderLayout.NORTH);
		initRightPanel();
		this.add(rightPanel, BorderLayout.CENTER);
	}

	public void initLeftPanel() {
		leftPanel.setLayout(new BorderLayout(0, 10));
		importChartPanel = createPieChart("Thống kê nhập hàng", 1);
		exportChartPanel = createPieChart("Thống kê xuất hàng", 2);

		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new BorderLayout(0, 10));

		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setLayout(new BorderLayout(30, 0));
		String[] optionData = { "Nhập", "Xuất" };
		optionComboBox = new JComboBox<String>(optionData);
		optionComboBox.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		optionComboBox.setVisible(true);
		optionComboBox.setSelectedIndex(0);
		optionComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				khoComboBox.setSelectedIndex(0);
				if (optionComboBox.getSelectedIndex() == 0) {
					if (leftPanel.isAncestorOf(exportChartPanel)) {
						leftPanel.remove(exportChartPanel);
						leftPanel.revalidate();
						leftPanel.add(importChartPanel, BorderLayout.CENTER);
						leftPanel.repaint();

						tablePanel.remove(exportScrollPane);
						tablePanel.revalidate();
						tablePanel.add(importScrollPane);
						tablePanel.repaint();
					}
				} else {

					if (leftPanel.isAncestorOf(importChartPanel)) {
						leftPanel.remove(importChartPanel);
						leftPanel.revalidate();
						leftPanel.repaint();
						leftPanel.add(exportChartPanel, BorderLayout.CENTER);

						tablePanel.remove(importScrollPane);
						tablePanel.revalidate();
						tablePanel.add(exportScrollPane);
						tablePanel.repaint();
					}
				}

			}
		});
		JLabel optionLabel = new JLabel("Lựa chọn thống kê:");
		comboBoxPanel.add(optionLabel, BorderLayout.WEST);
		comboBoxPanel.add(optionComboBox, BorderLayout.CENTER);

		JPanel timePanel = new JPanel();
		timePanel.setLayout(new BorderLayout(0, 5));

		JPanel startPanel = new JPanel();
		startPanel.setLayout(new BorderLayout(155, 0));
		JLabel startLabel = new JLabel("Bắt đầu");
		startTextArea = new JTextArea("yyyy-mm-dd", 1, 10);
		startTextArea.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		startTextArea.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (startTextArea.getText().equals("yyyy-mm-dd"))
					startTextArea.setText("");
			}
		});
		InputMap inpMap = startTextArea.getInputMap(JComponent.WHEN_FOCUSED);
		ActionMap actionMap = startTextArea.getActionMap();
		KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		inpMap.put(enterStroke, enterStroke.toString());
		actionMap.put(enterStroke.toString(), new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}

		});

		JPanel endPanel = new JPanel();
		endPanel.setLayout(new BorderLayout(150, 0));
		JLabel endLabel = new JLabel("Kết thúc");
		endTextArea = new JTextArea("yyyy-mm-dd", 1, 10);
		endTextArea.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (endTextArea.getText().equals("yyyy-mm-dd"))
					endTextArea.setText("");
			}
		});
		endTextArea.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		InputMap inpMap1 = endTextArea.getInputMap(JComponent.WHEN_FOCUSED);
		ActionMap actionMap1 = endTextArea.getActionMap();
		KeyStroke enterStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		inpMap1.put(enterStroke1, enterStroke1.toString());
		actionMap1.put(enterStroke1.toString(), new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}

		});
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 1));
		btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 270, 15, 270));
		JButton analyzeBtn = new JButton("Thống kê");
		analyzeBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String startData = startTextArea.getText().trim();
				String endData = endTextArea.getText().trim();
				HashMap<String, Integer> soluongphieu = new HashMap<String, Integer>();
				if (optionComboBox.getSelectedItem().equals("Nhập")) {
					ArrayList<PhieuNhapDTO> arr;

					if ((startData.equals("") && endData.equals(""))
							|| startData.equals("yyyy-mm-dd") && endData.equals("yyyy-mm-dd")) {
						arr = new PhieuNhapBUS().getAllPhieuNhap();

						for (int i = 0; i < arr.size(); i++) {
							String makho = arr.get(i).getMakho();
							if (soluongphieu.containsKey(makho)) {
								soluongphieu.put(makho, soluongphieu.get(makho) + 1);
							} else {
								soluongphieu.put(makho, 1);
							}
						}
					} else if ((startData.equals("") || endData.equals("")) || startData.equals("yyyy-mm-dd")
							|| endData.equals("yyyy-mm-dd")) {
						if (!startData.equals("") && startData.equals("yyyy-mm-dd")) {
							if(endTextArea.equals(comboBoxPanel))
							if (endTextArea.equals("")&&!endTextArea.getText().matches("\\d{4}-\\d{2}-\\d{2}") ) {
								JOptionPane.showMessageDialog(null, "Cần đúng định dạng yyyy-mm-dd");
								startTextArea.setText("yyyy-mm-dd");
								endTextArea.setText("yyyy-mm-dd");
							}
							arr = new PhieuNhapBUS().getByDate(endData, "<");

							for (int i = 0; i < arr.size(); i++) {
								String makho = arr.get(i).getMakho();
								if (soluongphieu.containsKey(makho)) {
									soluongphieu.put(makho, soluongphieu.get(makho) + 1);
								} else {
									soluongphieu.put(makho, 1);
								}
							}

						} else {
							if (!startData.equals("")&& !startData.matches("\\d{4}-\\d{2}-\\d{2}")) {
								JOptionPane.showMessageDialog(null, "Cần đúng định dạng yyyy-mm-dd");
								startTextArea.setText("yyyy-mm-dd");
								endTextArea.setText("yyyy-mm-dd");
							}
							arr = new PhieuNhapBUS().getByDate(startData, ">");
							for (int i = 0; i < arr.size(); i++) {
								String makho = arr.get(i).getMakho();
								if (soluongphieu.containsKey(makho)) {
									soluongphieu.put(makho, soluongphieu.get(makho) + 1);
								} else {
									soluongphieu.put(makho, 1);
								}
							}
						}

					} else {
						arr = new PhieuNhapBUS().getStartEndDate(startData, endData);

						for (int i = 0; i < arr.size(); i++) {
							String makho = arr.get(i).getMakho();
							if (soluongphieu.containsKey(makho)) {
								soluongphieu.put(makho, soluongphieu.get(makho) + 1);
							} else {
								soluongphieu.put(makho, 1);
							}
						}
					}
					DefaultPieDataset result = new DefaultPieDataset();
					HashMap<String, Integer> map = new HashMap<>();

					map.putAll(soluongphieu);

					for (Map.Entry<String, Integer> p : map.entrySet()) {
						result.setValue(p.getKey(), p.getValue());
					}

					// Remove the old chart panel from the JPanel
					if (importChartPanel != null) {
						leftPanel.remove(importChartPanel);
					}

					// Create and add the new chart panel to the JPanel
					importChartPanel = createPieChart("Thống kê Xuất", result);
					leftPanel.add(importChartPanel);

					// Repaint the parent panel to reflect the changes
					leftPanel.revalidate();
					leftPanel.repaint();

					ArrayList<PhieuNhapDTO> pnList = arr;

					DefaultTableModel model = (DefaultTableModel) importTable.getModel();
					model.setRowCount(0);
					for (int i = 0; i < pnList.size(); i++) {
						String mapn = pnList.get(i).getMaphieu();
						String makho = pnList.get(i).getMakho();
						String mangtao = pnList.get(i).getManguoitao();
						String mancc = pnList.get(i).getMancc();
						String ngaytao = pnList.get(i).getNgaytao().toString();
						String tongtien = NumberFormat.getInstance().format(pnList.get(i).getTongtien()) + "đ";
						model.addRow(new Object[] { mapn, makho, mangtao, mancc, ngaytao, tongtien });
					}
					importTable.repaint();

				} else {
					ArrayList<PhieuXuatDTO> arr;

					if ((startData.equals("") && endData.equals(""))
							|| startData.equals("yyyy-mm-dd") && endData.equals("yyyy-mm-dd")) {
						arr = new PhieuXuatBUS().getAllPhieuXuat();

						for (int i = 0; i < arr.size(); i++) {
							String makho = arr.get(i).getMakho();
							if (soluongphieu.containsKey(makho)) {
								soluongphieu.put(makho, soluongphieu.get(makho) + 1);
							} else {
								soluongphieu.put(makho, 1);
							}
						}
					} else if ((startData.equals("") || endData.equals("")) || startData.equals("yyyy-mm-dd")
							|| endData.equals("yyyy-mm-dd")) {
						if (startData.equals("") || startData.equals("yyyy-mm-dd")) {
							if(endTextArea.equals(comboBoxPanel))
								if (endTextArea.equals("")&&!endTextArea.getText().matches("\\d{4}-\\d{2}-\\d{2}") ) {
									JOptionPane.showMessageDialog(null, "Cần đúng định dạng yyyy-mm-dd");
									startTextArea.setText("yyyy-mm-dd");
									endTextArea.setText("yyyy-mm-dd");
								}
							arr = new PhieuXuatBUS().getByDate(endData, "<");

							for (int i = 0; i < arr.size(); i++) {
								String makho = arr.get(i).getMakho();
								if (soluongphieu.containsKey(makho)) {
									soluongphieu.put(makho, soluongphieu.get(makho) + 1);
								} else {
									soluongphieu.put(makho, 1);
								}
							}

						} else {
							if (!startData.equals("")&& !startData.matches("\\d{4}-\\d{2}-\\d{2}")) {
								JOptionPane.showMessageDialog(null, "Cần đúng định dạng yyyy-mm-dd");
								startTextArea.setText("yyyy-mm-dd");
								endTextArea.setText("yyyy-mm-dd");
							}
							arr = new PhieuXuatBUS().getByDate(startData, ">");
							for (int i = 0; i < arr.size(); i++) {
								String makho = arr.get(i).getMakho();
								if (soluongphieu.containsKey(makho)) {
									soluongphieu.put(makho, soluongphieu.get(makho) + 1);
								} else {
									soluongphieu.put(makho, 1);
								}
							}
						}

					} else {
						arr = new PhieuXuatBUS().getStartEndDate(startData, endData);

						for (int i = 0; i < arr.size(); i++) {
							String makho = arr.get(i).getMakho();
							if (soluongphieu.containsKey(makho)) {
								soluongphieu.put(makho, soluongphieu.get(makho) + 1);
							} else {
								soluongphieu.put(makho, 1);
							}
						}
					}
					DefaultPieDataset result = new DefaultPieDataset();
					HashMap<String, Integer> map = new HashMap<>();

					map.putAll(soluongphieu);

					for (Map.Entry<String, Integer> p : map.entrySet()) {
						result.setValue(p.getKey(), p.getValue());
					}

					// Remove the old chart panel from the JPanel
					if (exportChartPanel != null) {
						leftPanel.remove(exportChartPanel);
					}

					// Create and add the new chart panel to the JPanel
					exportChartPanel = createPieChart("Thống kê Xuất", result);
					leftPanel.add(exportChartPanel);

					// Repaint the parent panel to reflect the changes
					leftPanel.revalidate();
					leftPanel.repaint();
					ArrayList<PhieuXuatDTO> listCT = arr;
					DefaultTableModel model = (DefaultTableModel) exportTable.getModel();
					model.setRowCount(0);
					for (int i = 0; i < listCT.size(); i++) {
						String mapx = listCT.get(i).getMapx();
						String makho = listCT.get(i).getMakho();
						String makh = listCT.get(i).getManguoitao();
						String mangtao = listCT.get(i).getManguoitao();
						String ngaytao = listCT.get(i).getThoigiantao().toString();
						String tongtien = NumberFormat.getInstance().format(listCT.get(i).getTongtien()) + "đ";
						model.addRow(new Object[] { mapx, makho, mangtao, makh, ngaytao, tongtien });
					}

					exportTable.repaint();

				}

				startTextArea.setText("yyyy-mm-dd");
				endTextArea.setText("yyyy-mm-dd");
			}
		});

		startPanel.add(startLabel, BorderLayout.WEST);
		startPanel.add(startTextArea, BorderLayout.CENTER);
		endPanel.add(endLabel, BorderLayout.WEST);
		endPanel.add(endTextArea, BorderLayout.CENTER);

		timePanel.add(startPanel, BorderLayout.NORTH);
		timePanel.add(endPanel, BorderLayout.SOUTH);

		btnPanel.add(analyzeBtn);

		optionPanel.add(comboBoxPanel, BorderLayout.NORTH);
		optionPanel.add(timePanel, BorderLayout.WEST);
		optionPanel.add(btnPanel, BorderLayout.SOUTH);

		this.leftPanel.add(optionPanel, BorderLayout.NORTH);
		this.leftPanel.add(importChartPanel, BorderLayout.CENTER);
	}

	public void initRightPanel() {
		this.rightPanel.setLayout(new BorderLayout());
		this.rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 50));
		initImportTable();
		initExportTable();

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		infoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin nhập hàng"));

		JLabel khoLabel = new JLabel("Kho hàng:");
		ArrayList<String> list = new PhieuNhapBUS().getAllMakho();
		String[] khoData = new String[list.size() + 1];
		khoData[0] = "Tất cả kho";
		int i = 1;
		int j = 0;
		while (j < list.size()) {
			khoData[i++] = list.get(j++);
		}
		khoComboBox = new JComboBox<String>(khoData);
		khoComboBox.setSelectedIndex(0);
		khoComboBox.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		khoComboBox.setVisible(true);
		khoComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = (String) khoComboBox.getSelectedItem();
				String condition = "makho";
				if (leftPanel.isAncestorOf(importChartPanel)) {
					ArrayList<PhieuNhapDTO> pnList;
					if (khoComboBox.getSelectedIndex() == 0) {
						pnList = new PhieuNhapBUS().getAllPhieuNhap();
					} else {
						pnList = new PhieuNhapBUS().getByCondition(data, condition);
					}

					DefaultTableModel model = (DefaultTableModel) importTable.getModel();
					model.setRowCount(0);
					for (int i = 0; i < pnList.size(); i++) {
						String mapn = pnList.get(i).getMaphieu();
						String makho = pnList.get(i).getMakho();
						String mangtao = pnList.get(i).getManguoitao();
						String mancc = pnList.get(i).getMancc();
						String ngaytao = pnList.get(i).getNgaytao().toString();
						String tongtien = NumberFormat.getInstance().format(pnList.get(i).getTongtien()) + "đ";
						model.addRow(new Object[] { mapn, makho, mangtao, mancc, ngaytao, tongtien });
					}
					importTable.repaint();
				} else if (leftPanel.isAncestorOf(exportChartPanel)) {
					ArrayList<PhieuXuatDTO> pxList = new PhieuXuatBUS().getByMakho(data);
					if (khoComboBox.getSelectedIndex() == 0) {
						pxList = new PhieuXuatBUS().getAllPhieuXuat();
					} else {
						pxList = new PhieuXuatBUS().getByMakho(data);
					}

					DefaultTableModel model = (DefaultTableModel) exportTable.getModel();
					model.setRowCount(0);
					for (int i = 0; i < pxList.size(); i++) {
						String mapx = pxList.get(i).getMapx();
						String makho = pxList.get(i).getMakho();
						String makh = pxList.get(i).getManguoitao();
						String mangtao = pxList.get(i).getManguoitao();
						String ngaytao = pxList.get(i).getThoigiantao().toString();
						String tongtien = NumberFormat.getInstance().format(pxList.get(i).getTongtien()) + "đ";
						model.addRow(new Object[] { mapx, makho, mangtao, makh, ngaytao, tongtien });
					}

					exportTable.repaint();
				}

			}
		});

		infoPanel.add(khoLabel);
		infoPanel.add(khoComboBox);

		tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(1, 1));
		tablePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		tablePanel.add(importScrollPane);

		rightPanel.add(infoPanel, BorderLayout.NORTH);
		rightPanel.add(tablePanel, BorderLayout.CENTER);
	}

	public void initImportTable() {
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

			}
		});
		importTable.repaint();
		importTable.setDefaultEditor(Object.class, null);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		TableColumnModel tableCol = importTable.getColumnModel();
		tableCol.getColumn(0).setPreferredWidth(20);
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
		importScrollPane = new JScrollPane(importTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		importScrollPane.setVisible(true);

	}

	public void initExportTable() {
		ArrayList<PhieuXuatDTO> listCT = new PhieuXuatBUS().getAllPhieuXuat();

		String[] columnData = { "Mã phiếu", "Mã kho ", "Mã ngtao", "Mã khách", "Ngày tạo", "Tổng tiền" };
		TableModel tableModel = new DefaultTableModel(columnData, 30);
		exportTable = new JTable(tableModel);
		DefaultTableModel model = (DefaultTableModel) exportTable.getModel();
		model.setRowCount(0);
		for (int i = 0; i < listCT.size(); i++) {
			String mapx = listCT.get(i).getMapx();
			String makho = listCT.get(i).getMakho();
			String makh = listCT.get(i).getManguoitao();
			String mangtao = listCT.get(i).getManguoitao();
			String ngaytao = listCT.get(i).getThoigiantao().toString();
			String tongtien = NumberFormat.getInstance().format(listCT.get(i).getTongtien()) + "đ";
			model.addRow(new Object[] { mapx, makho, mangtao, makh, ngaytao, tongtien });
		}

		exportTable.repaint();
		exportTable.setDefaultEditor(Object.class, null);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		TableColumnModel tableCol = exportTable.getColumnModel();
		tableCol.getColumn(0).setPreferredWidth(20);
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
		exportScrollPane = new JScrollPane(exportTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		exportScrollPane.setVisible(true);

	}

	public ChartPanel createPieChart(String chartTitle, int loai) {
		PieDataset dataset = createDataSet(loai);
		JFreeChart chart = createChart(dataset, chartTitle);
		ChartPanel chartPanel = new ChartPanel(chart);

		chartPanel.setPreferredSize(new java.awt.Dimension(636, 500));
		return chartPanel;
	}

	public ChartPanel createPieChart(String chartTitle, PieDataset result) {
		PieDataset dataset = result;

		JFreeChart chart = createChart(dataset, chartTitle);
		ChartPanel chartPanel = new ChartPanel(chart);

		chartPanel.setPreferredSize(new java.awt.Dimension(636, 500));
		return chartPanel;
	}

	public PieDataset createDataSet(int loai) {
		DefaultPieDataset result = new DefaultPieDataset();

		HashMap<String, Integer> map = new HashMap<>();
		if (loai == 1) {
			HashMap<String, Integer> mapN = countSoLuongNhap();
			map.putAll(mapN);
		} else {
			HashMap<String, Integer> mapX = countSoLuongXuat();
			map.putAll(mapX);
		}
		for (Map.Entry<String, Integer> p : map.entrySet()) {
			result.setValue(p.getKey(), p.getValue());
		}
		return result;
	}

	private JFreeChart createChart(PieDataset dataset, String title) {
		System.out.println("Create Chart");
		JFreeChart chart = ChartFactory.createPieChart3D(title, // chart title
				dataset, // data
				true, // include legend
				true, true);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1}"));
		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"),
				new DecimalFormat("0%"));
		plot.setLabelGenerator(gen);
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		plot.setCircular(true);
		return chart;

	}

	public HashMap<String, Integer> countSoLuongNhap() {
		ArrayList<PhieuNhapDTO> arr = new PhieuNhapBUS().getAllPhieuNhap();
		HashMap<String, Integer> soluongphieu = new HashMap<String, Integer>();
		for (int i = 0; i < arr.size(); i++) {
			String makho = arr.get(i).getMakho();
			if (soluongphieu.containsKey(makho)) {
				soluongphieu.put(makho, soluongphieu.get(makho) + 1);
			} else {
				soluongphieu.put(makho, 1);
			}
		}
		return soluongphieu;
	}

	public HashMap<String, Integer> countSoLuongXuat() {
		ArrayList<PhieuXuatDTO> arr = new PhieuXuatBUS().getAllPhieuXuat();
		HashMap<String, Integer> soluongphieu = new HashMap<String, Integer>();
		for (int i = 0; i < arr.size(); i++) {
			String makho = arr.get(i).getMakho();
			if (soluongphieu.containsKey(makho)) {
				soluongphieu.put(makho, soluongphieu.get(makho) + 1);
			} else {
				soluongphieu.put(makho, 1);
			}
		}
		return soluongphieu;
	}

	public static void main(String[] args) {
		JFrame fr = new JFrame("Chart");
		fr.setLayout(new FlowLayout());
		fr.setSize(1000, 1000);
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ThongKeGUI tk = new ThongKeGUI();
		fr.add(tk);
	}
}
