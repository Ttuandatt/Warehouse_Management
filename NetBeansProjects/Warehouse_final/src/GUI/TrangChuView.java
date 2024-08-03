/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class TrangChuView extends JPanel{
    public void giaoDienTrangChu(){
        setBackground(Color.YELLOW);
        setLayout(null);
        JLabel greeting = new JLabel("HELLO, THIS IS HOMEPAGE CLASS");
        greeting.setBounds(20,10,300,30);
        add(greeting);
    }
}
