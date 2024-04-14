package view.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class header extends JPanel {

    private int height, width;
    private JFrame frame;

    public header(int w, int h) {
        width = w;
        height = h;
        init();
    }

    public void init() {
        setLayout(null);
        setSize(width, height);
        setBackground(null);

        JLabel logo = new JLabel(new ImageIcon("./src/img/header_icon.png"), JLabel.CENTER);
        logo.setBounds(new Rectangle(30, 10, 25, 25));
        Font font = new Font("Segoe UI", Font.BOLD, 15);
        JLabel name = new JLabel("EduBook Store", JLabel.CENTER);
        name.setFont(font);
        name.setForeground(Color.white);
        name.setBounds(new Rectangle(60, 0, 280, 40));

        add(logo);
        add(name);

    }
}
