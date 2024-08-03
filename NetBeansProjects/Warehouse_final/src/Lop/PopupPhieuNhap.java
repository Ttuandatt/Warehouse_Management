package Lop;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;
import BUS.*;
import GUI.*;
import DAO.*;
import DTO.*;

public class PopupPhieuNhap extends JFrame {
	private SanPhamDTO sp;
	public PopupPhieuNhap(SanPhamDTO sp) {
		// TODO Auto-generated con
		this.sp=sp;
		this.init();
	}
	public void init() {
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		JPanel labelPanel=new JPanel();
		labelPanel.setBackground(Color.decode("#32ff7e"));
	
		Font font=new Font("Monospaced",Font.BOLD,30);
		JLabel labelPhieu= new JLabel("Thong tin chi tiet san pham:");
		labelPhieu.setFont(font);
		labelPhieu.setForeground(Color.WHITE);
		labelPhieu.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.setLayout(new BorderLayout());
		labelPanel.add(labelPhieu,BorderLayout.CENTER);
		
		JPanel detailPanel=new JPanel();
		detailPanel.setLayout(new GridLayout(4,3));
		String[] detailLabel= {"Mã SP","Tên SP","Số lượng","Giá bán","Bộ xử lý","Bộ nhớ","Ram","GPU","Kích thước màn ","Nhà cung cấp"};
		
		String[] detailData=new String[10];
		detailData[0]=sp.getMaMay();
		detailData[1]=sp.getTenMay();
		detailData[2]=Integer.toString(sp.getSoLuong());
		detailData[3]=Integer.toString(sp.getGia());
		detailData[4]=sp.getBoXuLy();
		detailData[5]=sp.getBoNho();
		detailData[6]=sp.getRam();
		detailData[7]=sp.getGPU();
		detailData[8]=sp.getKichthuocman();
		detailData[9]=sp.getNhaCungCap();
		for(int i=0;i<detailData.length;i++) {
			JLabel lb=new JLabel(detailLabel[i]+": "+detailData[i]);
			lb.setHorizontalAlignment(JLabel.CENTER);
			
			detailPanel.add(lb);

		}
		this.add(labelPanel,BorderLayout.NORTH);
		this.add(detailPanel,BorderLayout.CENTER);
		
	}
}