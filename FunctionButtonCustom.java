/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author ACER
 */
public class FunctionButtonCustom extends JButton {
    //Constructors
    public FunctionButtonCustom(String text, String icon, String color){
        init(text, icon, color);
    }
    public FunctionButtonCustom(String text, String icon){
        init(text, icon, "");
    }
    public FunctionButtonCustom(String text){
        init(text,"","");
    }
    
    public void init(String text, String icon, String color){
        this.setText(text);
        if(!icon.equals("")){
            ImageIcon originalIcon = new ImageIcon(icon);
            Image img = originalIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
            this.setIcon(new ImageIcon(img));
        }
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        if(!color.equals(""))
            this.setBackground(Color.decode(color));
        else
            this.setBackground(Color.WHITE);
        this.setBorderPainted(false);
        this.setPreferredSize(new Dimension(60,60));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                setBackground(getBackground().darker());
                setOpaque(true);
            }
            @Override
            public void mouseExited(MouseEvent e){
                if(!color.equals(""))
                    setBackground(Color.decode(color));
                else
                    setBackground(Color.WHITE);
                setOpaque(true);
            }
        });
                
    }
    
}
