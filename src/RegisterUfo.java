package Aplikasi.Ufo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterUfo extends JFrame implements ActionListener, MouseListener {

    public static void main(String[] args) {

        new RegisterUfo();

    }

    private JPanel pane, paneUp;
    private JLabel username, password, logo, pu2, pp2, info;
    private JTextField textUsername, u2;
    private JPasswordField textPassword, p2;
    private JButton loginButton, xButton;

    public RegisterUfo() {

        setTitle("UFO");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);               
        setLayout(null);

        pane = new JPanel();
        pane.setBackground(new Color(53,53,65));
        pane.setBounds(400, 25, 1, 500);
        add(pane);

        xButton = new JButton("X");
        xButton.setForeground(Color.black);
        xButton.setBounds(750, 0, 50, 30);
        xButton.setFocusable(false);
        xButton.setBackground(Color.white);
        xButton.addActionListener(this); 
        xButton.addMouseListener(this);
        add(xButton);
        
        paneUp = new JPanel();
        paneUp.setBackground(Color.black);
        paneUp.setBounds(0, 0, 800, 30);
        add(paneUp);

        info = new JLabel("Sudah Punya Akun? Login");
        info.setBounds(530, 477, 220, 15);
        info.setForeground(Color.white);
        info.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginUfo().setVisible(true);
            }
        });
        add(info);

        ImageIcon ufo = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\ufo123r.png");
        setIconImage(ufo.getImage());

        ImageIcon ufoLogo = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\logo.png");

        logo = new JLabel();
        logo.setIcon(ufoLogo);
        logo.setHorizontalTextPosition(JLabel.CENTER);
        logo.setVerticalTextPosition(JLabel.BOTTOM);
        logo.setBounds(535, 90, 200, 200);
        add(logo);

        ImageIcon ufos = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\uufo.png");

        logo = new JLabel();
        logo.setIcon(ufos);
        logo.setHorizontalTextPosition(JLabel.CENTER);
        logo.setVerticalTextPosition(JLabel.BOTTOM);
        logo.setBounds(142, 210, 200, 200);
        add(logo);

        username = new JLabel("Username");
        username.setBounds(535, 268, 90, 20);
        username.setForeground(new Color(135,133,133));
        add(username);

        textUsername = new JTextField();
        textUsername.setBounds(525, 269, 160, 20);        
        add(textUsername);

        password = new JLabel("Password");
        password.setBounds(535, 307, 90, 20);
        password.setForeground(new Color(135,133,133));
        add(password);

        textPassword = new JPasswordField();
        textPassword.setBounds(525, 310, 160, 20);
        add(textPassword);
        
        pp2 = new JLabel("Retry Password");
        pp2.setBounds(535, 350, 90, 20);
        pp2.setForeground(new Color(135,133,133));
        add(pp2);

        p2 = new JPasswordField();
        p2.setBounds(525, 351, 160, 20);        
        add(p2);

        pu2 = new JLabel("Full Name");
        pu2.setBounds(535, 390, 90, 20);
        pu2.setForeground(new Color(135,133,133));
        add(pu2);

        u2 = new JTextField();
        u2.setBounds(525, 392, 160, 20);
        add(u2);

        loginButton = new JButton("REGISTER");
        loginButton.setBounds(550, 435, 102, 20);
        loginButton.setFocusable(false);
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.white);
        loginButton.addActionListener(this);
        add(loginButton);
        
        getContentPane().setBackground(Color.gray);                        
        setUndecorated(true);
        setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == xButton) {
            System.exit(0);
        }
        
        String username = textUsername.getText();
        String password = String.valueOf(textPassword.getPassword());
        String uPassword = String.valueOf(p2.getPassword());
        String namaP = u2.getText();
        
        PreparedStatement ps;
        String sql = "INSERT INTO `tabel_login`(`username`, `password`, `full_name`) VALUES (?,?,?)";

        try {
            ps = Koneksi.getKoneksi().prepareStatement(sql);
            
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, namaP);
            
             if (username.isEmpty() && password.isEmpty() && uPassword.isEmpty() && namaP.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi Semua Data", "Message", JOptionPane.ERROR_MESSAGE);
            } else if(username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi Username", "Message", JOptionPane.ERROR_MESSAGE);
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi Password", "Message", JOptionPane.ERROR_MESSAGE);
            } else if(uPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi Ulangi Password", "Message", JOptionPane.ERROR_MESSAGE);
            } else if(namaP.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi Nama Panjang", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(uPassword)) {
                JOptionPane.showMessageDialog(null, "Password Salah", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                dispose();
                new LoginUfo().setVisible(true);                
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }

            
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Aktifkan Service MySQL Menggunakan XAMPP", "", JOptionPane.WARNING_MESSAGE);
            System.out.println(ee.getMessage());
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        xButton.setBackground(Color.red);       
        xButton.setForeground(Color.white);              
    }

    @Override
    public void mouseExited(MouseEvent e) {
        xButton.setBackground(Color.white);
        xButton.setForeground(Color.black);
    }

}
