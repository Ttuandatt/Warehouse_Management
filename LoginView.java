package View;

import Model.LoginModel;
import Controller.LoginController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import javax.swing.*;
public class LoginView {
    private static JTextField tfUsername = new JTextField(); // Định nghĩa JTextField ở mức lớp
    private static JPasswordField pfPassword = new JPasswordField(); // Định nghĩa JTextField ở mức lớp
    public static Scanner input = new Scanner(System.in);
    public void showMessage(String msg){ 
        System.out.println(msg); 
    }
    
    JPanel panelBottom = new JPanel();  //Khởi tạo ở cấp độ lớp để các phương thức tương tác, ví dụ phương thức closeLoginFrame
    JPanel panelTop = new JPanel(new BorderLayout());
    
    public JFrame giaoDienLogin() {
        JFrame f = new JFrame("Login Page");
        
        //PANEL TOP
        panelTop.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management\\src\\main\\java\\Images\\log2.png");
        Image img = icon.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);;
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel imageLabel = new JLabel(scaledIcon);
        panelTop.add(imageLabel, BorderLayout.CENTER);
        f.add(panelTop);
        
        //PANEL BOTTOM
        
        panelBottom.setLayout(null);
        panelBottom.setBackground(Color.WHITE);
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(170,20,90,30);
        panelBottom.add(usernameLabel);
        tfUsername.setBounds(170, 45, 200, 26);
        panelBottom.add(tfUsername);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(170, 71, 90, 30);
        pfPassword.setBounds(170, 96, 200, 26);
        panelBottom.add(pfPassword);
        JButton logButton = new JButton("Đăng nhập");
        logButton.setBounds(219, 130, 100, 30);
        logButton.setBackground(Color.decode("#56c2f5"));
        logButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                logButton.setBackground(Color.decode("#bde2f2"));   //Đổi màu khi hover chuột vào nứt đăng nhập
            }
            @Override
            public void mouseExited(MouseEvent e){
                logButton.setBackground(Color.decode("#56c2f5"));   //Đổi màu khi hover chuột khỏi nút đăng nhập
            }
        });
        logButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // Xử lý đăng nhập khi nhấp vào nút Đăng nhập
                LoginModel user = getInfo();
                LoginController controller = new LoginController(LoginView.this);
                controller.checkAndLogin(user);
            }
        });
        panelBottom.add(logButton);
        panelBottom.add(passwordLabel);

        
        f.add(panelBottom);
        f.setSize(560, 560);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(2,1));
        f.setVisible(true);
        
        return f;
    }
    public LoginModel getInfo(){
        LoginModel user = new LoginModel();
        user.setUsername(tfUsername.getText());
        user.setPassword(new String(pfPassword.getPassword())); //Phương thức getPassword trả về 1 mảng các ký tự chứ không phải 1 chuối, vì vậy dùng new String() để tạo thành 1 chuỗi từ mảng các ký tự đó
        return user;
    }
    public void closeLoginFrame() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelBottom); // Lấy JFrame cha của panelBottom
        frame.dispose(); // Đóng frame đăng nhập
}   
    public static void main(String[] args){
        LoginView view = new LoginView();
        view.giaoDienLogin();
    }
}
/*
Chinh kich co anh cho fit voi doi tuong
ImageIcon icon = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\BT_JAVA_LOANDO\\src\\main\\java\\com\\mycompany\\icon1.png");
Image img = icon.getImage().getScaledInstance(96, 30, java.awt.Image.SCALE_SMOOTH);
ImageIcon scaledIcon = new ImageIcon(img);
*/

