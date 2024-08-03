package GUI;

import BUS.LoginBUS;
import DAO.TaiKhoanDAO;
import DTO.LoginDTO;
import DTO.TaiKhoanDTO;
import GUI.InputFormGUI;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;

public class LoginGUI extends JFrame implements KeyListener {
    JPanel pnlMain, pnlLogIn;
    public static Scanner input = new Scanner(System.in);
    private LoginBUS loginBUS;
    private String username;
    private String password;
    JLabel lblImage, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
    InputFormGUI txtUsername;
    InputFormGUI txtPassword;
    Color FontColor = new Color(96, 125, 139);

    public LoginGUI() {
        initComponent();
        txtUsername.setText("");
        txtPassword.setPass("");
    }

    private void initComponent() {
        FlatRobotoFont.install();
        FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);
        FlatLaf.setPreferredLightFontFamily(FlatRobotoFont.FAMILY_LIGHT);
        FlatLaf.setPreferredSemiboldFontFamily(FlatRobotoFont.FAMILY_SEMIBOLD);
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        UIManager.put("PasswordField.showRevealButton", true);
        this.setSize(new Dimension(1000, 500));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0, 0));
        this.setTitle("Đăng nhập");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame jf = this;

        imgIntro();

        pnlMain = new JPanel();
        pnlMain.setBackground(Color.white);
        pnlMain.setBorder(new EmptyBorder(20, 0, 0, 0));

        pnlMain.setPreferredSize(new Dimension(500, 740));
        pnlMain.setLayout(new FlowLayout(1, 0, 10));

        lbl3 = new JLabel("ĐĂNG NHẬP VÀO HỆ THỐNG");
        lbl3.setFont(new Font(FlatRobotoFont.FAMILY_SEMIBOLD, Font.BOLD, 20));
        pnlMain.add(lbl3);

        JPanel paneldn = new JPanel();
        paneldn.setBackground(Color.BLACK);
        paneldn.setPreferredSize(new Dimension(400, 200));
        paneldn.setLayout(new GridLayout(2, 1));

        txtUsername = new InputFormGUI("Tên đăng nhập");
        paneldn.add(txtUsername);
        txtPassword = new InputFormGUI("Mật khẩu", "password");
        paneldn.add(txtPassword);

        txtUsername.getTxtForm().addKeyListener(this);
        txtPassword.getTxtPass().addKeyListener(this);

        pnlMain.add(paneldn);

        lbl6 = new JLabel("ĐĂNG NHẬP");
        lbl6.setFont(new Font(FlatRobotoFont.FAMILY, Font.BOLD, 16));
        lbl6.setForeground(Color.white);

        pnlLogIn = new JPanel();
        pnlLogIn.putClientProperty( FlatClientProperties.STYLE, "arc: 99" );
        pnlLogIn.setBackground(Color.BLACK);
        pnlLogIn.setPreferredSize(new Dimension(380, 45));
        pnlLogIn.setLayout(new FlowLayout(1, 0, 15));

        pnlLogIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                pnlLogInMouseEntered(evt);
                pnlLogIn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                try {
                    login();
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent evt) {
                try {
                    pnlLogInMousePressed(evt);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                pnlLogInMouseExited(evt);
            }
        });
        pnlLogIn.add(lbl6);

  
        pnlMain.add(pnlLogIn);

        this.add(pnlMain, BorderLayout.EAST);

    }

  private void login() throws UnsupportedLookAndFeelException {
        // Retrieve username and password entered by the user
        username = txtUsername.getText();
        password = txtPassword.getPass();
        
        // Create a DTO object with the user's login information
        LoginDTO user = new LoginDTO(username, password);
        
        // Perform the login operation using the BUS class
        LoginBUS loginBUS = new LoginBUS();
        loginBUS.checkAndLogin(user, this);
    }

  public void closeLoginFrame() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(pnlMain); // Lấy JFrame cha của panelBottom
        frame.dispose(); // Đóng frame đăng nhập
    }
 
    
    private void pnlLogInMousePressed(java.awt.event.MouseEvent evt) throws UnsupportedLookAndFeelException {
        
              
    }
   

    private void pnlLogInMouseEntered(java.awt.event.MouseEvent evt) {
        pnlLogIn.setBackground(FontColor);
        pnlLogIn.setForeground(Color.black);
    }

    private void pnlLogInMouseExited(java.awt.event.MouseEvent evt) {

        pnlLogIn.setBackground(Color.BLACK);
        pnlLogIn.setForeground(Color.white);
    }

    public static void main(String[] args) {
      
        LoginGUI login = new LoginGUI();
        login.setVisible(true);
    }

    public void imgIntro() {
        JPanel bo = new JPanel();
        bo.setBorder(new EmptyBorder(3, 10, 5, 5));
        bo.setPreferredSize(new Dimension(500, 740));
        bo.setBackground(Color.white);
        this.add(bo, BorderLayout.WEST);

        lblImage = new JLabel();
//        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/phone2.jpg")));
        lblImage.setIcon(new FlatSVGIcon("./Images/login-image.svg"));
        bo.add(lblImage);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//            try {
//                checkLogin();
//            } catch (UnsupportedLookAndFeelException ex) {
//                Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
