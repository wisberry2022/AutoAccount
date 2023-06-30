package org.program.ui;

import javax.swing.*;
import java.awt.*;

public class AccountManager extends JFrame {

    private final static String FONT_TYPE = "Malgun Gothic";
    private final static int FONT_SIZE = 15;
    private final Panel pManager = new Panel();
    private final Font DEFAULT_FONT = new Font(FONT_TYPE, Font.PLAIN, FONT_SIZE);

    public AccountManager() {
        UIInit();
//        mainPanel.add(new Button("Okay"));
//        mainPanel.add(new Button("Okay"));
//        mainPanel.add(new Button("Okay"));
        LayoutManager gridBag = new GridBagLayout();
        setLayout(LayoutFactory.getGridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        constraints.gridx = 0;
        constraints.gridy = 0;

        JPanel header = pManager.getHeader("통장관리 프로그램");
        constraints.gridy = 1;
        constraints.weighty = 0.2;
        add(header, constraints);

        JButton btn = new JButton("Okay");

        constraints.gridy = 2;
        constraints.weighty = 0.9;
        add(btn, constraints);

        setVisible(true);
    }

    private void UIInit() {
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("통장관리 프로그램");
        setResizable(false);
        setLocationRelativeTo(null);
        setFont(new Font(FONT_TYPE, Font.PLAIN, FONT_SIZE));
    }

    
    public static void main(String[] args) {
        JFrame program = new AccountManager();
    }
}
