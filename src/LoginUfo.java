package Aplikasi.Ufo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginUfo extends JFrame implements ActionListener, MouseListener {

    public static void main(String[] args) {

        new LoginUfo();

    }

    private JPanel pane, paneUp;
    private JLabel username, password, logo, info;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JButton loginButton, xButton;
    Connection con = null;

    public LoginUfo() {

        setTitle("UFO");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        pane = new JPanel();
        pane.setBackground(new Color(53, 53, 65));
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

        ImageIcon ufo = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\ufo123r.png");
        setIconImage(ufo.getImage());

        ImageIcon ufoLogo = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\logo.png");

        logo = new JLabel();
        logo.setIcon(ufoLogo);
        logo.setHorizontalTextPosition(JLabel.CENTER);
        logo.setVerticalTextPosition(JLabel.BOTTOM);
        logo.setBounds(122, 150, 200, 200);
        add(logo);

        ImageIcon ufos = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\uufo.png");

        logo = new JLabel();
        logo.setIcon(ufos);
        logo.setHorizontalTextPosition(JLabel.CENTER);
        logo.setVerticalTextPosition(JLabel.BOTTOM);
        logo.setBounds(530, 207, 200, 200);
        add(logo);

        info = new JLabel("Belum Punya Akun? Registrasi");
        info.setBounds(110, 456, 220, 15);
        info.setForeground(Color.white);
        info.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new RegisterUfo().setVisible(true);
            }
        });
        add(info);

        username = new JLabel("Username");
        username.setBounds(130, 320, 90, 20);
        username.setForeground(new Color(135, 133, 133));
        add(username);

        textUsername = new JTextField();
        textUsername.setBounds(115, 320, 160, 20);
        add(textUsername);

        password = new JLabel("Password");
        password.setBounds(130, 350, 90, 20);
        password.setForeground(new Color(135, 133, 133));
        add(password);

        textPassword = new JPasswordField();
        textPassword.setBounds(115, 350, 160, 20);
        add(textPassword);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(150, 380, 80, 20);
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
        } else if (e.getSource() == loginButton) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_tiketufo", "root", "");

                Statement stm = con.createStatement();

                String username = textUsername.getText();
                String password = String.valueOf(textPassword.getPassword());

                String sql = "SELECT * FROM tabel_login WHERE username='"
                        + username + "' AND password='" + password + "'";
                ResultSet rs = stm.executeQuery(sql);
            
            if (username.equals("") && password.equals("")) {
                        JOptionPane.showMessageDialog(null, "Isi Username dan Password", "Message", JOptionPane.ERROR_MESSAGE);
                    } else if (password.equals("")) {
                        JOptionPane.showMessageDialog(null, "Isi Password", "Message", JOptionPane.ERROR_MESSAGE);
                    } else if (username.equals("")) {
                        JOptionPane.showMessageDialog(null, "Isi Username", "Message", JOptionPane.ERROR_MESSAGE);
                    } else if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Selamat Datang " + username);
                        dispose();
                        new MainMenuUfo().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username & Password Salah", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, "Aktifkan Service MySQL Menggunakan XAMPP", "", JOptionPane.WARNING_MESSAGE);
                System.out.println(ee.getMessage());
            }
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
