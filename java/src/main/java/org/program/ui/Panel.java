package org.program.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Panel extends JFrame {

    public JPanel getLayoutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        return panel;
    }

    public JPanel getBody() {
        JPanel panel = new JPanel();
        return panel;
    }

    public JPanel getHeader(String label) {
        JPanel header = new JPanel();
        JLabel textLabel = new JLabel(label);
        textLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
        textLabel.setSize(100,100);
        header.setBorder(new EmptyBorder(10,20, 0, 10));
        header.add(textLabel);
        return header;
    }

    public JPanel getGridBagPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        return panel;
    }

}
