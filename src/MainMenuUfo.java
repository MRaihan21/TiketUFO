package Aplikasi.Ufo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuUfo extends JFrame implements ActionListener, MouseListener {

    public static void main(String[] args) {

        new MainMenuUfo();

    }
    
    JLabel logo, mm;
    JPanel left, paneUp;
    JButton xButton;

    public MainMenuUfo() {

        setTitle("UFO");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        ImageIcon ufoLogo = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\logo.png");

        logo = new JLabel();
        logo.setIcon(ufoLogo);
        logo.setHorizontalTextPosition(JLabel.CENTER);
        logo.setVerticalTextPosition(JLabel.BOTTOM);
        logo.setBounds(45, 31, 200, 200);
        add(logo);
        
        mm = new JLabel("MAIN MENU");
        mm.setBounds(35, 220, 142, 29);
        mm.setForeground(Color.white);
        mm.setFont(new Font("arial", Font.BOLD, 24));
        add(mm);

        paneUp = new JPanel();
        paneUp.setBackground(Color.black);
        paneUp.setBounds(0, 0, 950, 30);
        add(paneUp);

        left = new JPanel();
        left.setBackground(new Color(53, 53, 65));
        left.setBounds(0, 0, 200, 600);
        this.add(left);

        xButton = new JButton("X");
        xButton.setForeground(Color.black);
        xButton.setBounds(950, 0, 50, 30);
        xButton.setFocusable(false);
        xButton.setBackground(Color.white);
        xButton.addActionListener(this);
        xButton.addMouseListener(this);
        add(xButton);                

        getContentPane().setBackground(new Color(38, 38, 48));
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == xButton) {
            System.exit(0);
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
