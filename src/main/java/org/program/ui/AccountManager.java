package org.program.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;

public class AccountManager extends JFrame {

    private final static String FONT_TYPE = "Malgun Gothic";
    private final static int FONT_SIZE = 15;
    private final Panel pManager = new Panel();
    private final Font DEFAULT_FONT = new Font(FONT_TYPE, Font.PLAIN, FONT_SIZE);
    private final DesignUtil dUtil = new DesignUtil();


    public AccountManager() {
        UIInit();

        setLayout(null);



        JPanel header = pManager.getHeader("통장관리 프로그램");
        header.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        header.setBounds(0,0,1200,50);
        add(header);

        JPanel MainBox = new JPanel();
        MainBox.setLayout(null);
        MainBox.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        MainBox.setBounds(2, 70, 1190, 500);
        add(MainBox);

        JPanel LeftBox = new JPanel();
        LeftBox.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.BLACK));
        LeftBox.setBounds(5, 7, 300, 390);

        JPanel InputField = new JPanel();
        JTextField accountInput = new JTextField();
        accountInput.setPreferredSize(DesignUtil.getDimension(220, 30));
        accountInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton submitBtn = new JButton("확인");
        submitBtn.setPreferredSize(DesignUtil.getDimension(60, 30));

        InputField.add(accountInput);
        InputField.add(submitBtn);

        JList myAccounts = new JList();
        myAccounts.setPreferredSize(DesignUtil.getDimension(290, 500));

        LeftBox.add(InputField);
        LeftBox.add(myAccounts);

        MainBox.add(LeftBox);

        JPanel RightBox = new JPanel();
        RightBox.setLayout(null);
        RightBox.setBounds(310, 7, 893, 397);

        JPanel NavPanel = new JPanel();
        NavPanel.setBounds(0,0,900, 50);
        NavPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.GRAY));

        JButton AccountInfo = new JButton("통장정보");
        AccountInfo.setPreferredSize(DesignUtil.getDimension(100, 40));
        JButton AutoDeposit = new JButton("자동이체");
        AutoDeposit.setPreferredSize(DesignUtil.getDimension(100, 40));

        NavPanel.add(AccountInfo);
        NavPanel.add(AutoDeposit);

        RightBox.add(NavPanel);

        JPanel TabMonitor = new JPanel();
        TabMonitor.setLayout(null);
        TabMonitor.setBounds(0, 0, 900, 450);

        RightBox.add(TabMonitor);
        MainBox.add(RightBox);


        setVisible(true);
    }

    private void UIInit() {
        setSize(1200, 500);
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
