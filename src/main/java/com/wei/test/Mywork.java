package com.wei.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 为为
 * @create 9/13
 */
public class Mywork extends JFrame {

    private static JTextField userName = new JTextField(15);
    private static JTextField oldPassword = new JPasswordField(15);
    private static JTextField newPassword = new JPasswordField(15);
    private static String fileUrl = "D:/user01.txt";
    static {
        File file = new File(fileUrl);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Mywork(){
        setTitle("用户注册");
        setBounds(1000, 100, 280,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel softLabel = new JLabel();
        softLabel.setForeground(new Color(73, 131, 255));
        softLabel.setFont(new Font("宋体", Font.BOLD, 18));
        softLabel.setHorizontalAlignment(SwingConstants.CENTER);

        softLabel.setText("用 户 注 册");
        getContentPane().add(softLabel, BorderLayout.NORTH);

        final JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        final JPanel infoPanel = new JPanel();
        contentPanel.add(infoPanel, BorderLayout.CENTER);



        final JLabel titleLabel = new JLabel();
        titleLabel.setText("   用 户 名 : ");
        infoPanel.add(titleLabel,BorderLayout.WEST);
        infoPanel.add(userName,BorderLayout.CENTER);


        final JLabel oldLabel = new JLabel();
        oldLabel.setText("      密   码 : ");
        infoPanel.add(oldLabel);
        infoPanel.add(oldPassword,BorderLayout.CENTER);

        final JLabel newLabel = new JLabel();
        newLabel.setText(" 重复密码 : ");
        infoPanel.add(newLabel);
        infoPanel.add(newPassword,BorderLayout.WEST);


        final JLabel gradeLable = new JLabel();
        gradeLable.setText("      性   别 : ");
        infoPanel.add(gradeLable,BorderLayout.WEST);
        ButtonGroup g=new ButtonGroup();
        final JRadioButton man = new JRadioButton("        男      ", true);
        final JRadioButton woman = new JRadioButton("        女      ", false);
        g.add(man);
        g.add(woman);
        infoPanel.add(man,BorderLayout.CENTER);
        infoPanel.add(woman,BorderLayout.CENTER);

        final JButton loginButton = new JButton(" 登 陆 ");
        final JButton revButton = new JButton(" 重 置 ");
        infoPanel.add(loginButton);
        infoPanel.add(revButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ret;
                    String time = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
                    ret = "时间："+ time+"\r\n";
                    FileOutputStream outputStream = new FileOutputStream(fileUrl,true);
                    String userNameText = userName.getText();
                    String oldText = oldPassword.getText();
                    ret += "姓名："+ userNameText+"\r\n" +"密码："+oldText+"\r\n";
                    if (man.isSelected()){
                        ret += "性别："+man.getText().trim()+"\r\n";
                    }else{
                        ret += "性别："+woman.getText().trim()+"\r\n";
                    }
                    outputStream.write(ret.getBytes());
                    outputStream.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        revButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName.setText("");
                oldPassword.setText("");
                newPassword.setText("");
                man.setSelected(true);
            }
        });

        newPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                String oldText = oldPassword.getText();
                String newText = newPassword.getText();
                if(!oldText.equals(newText)){
                    JOptionPane.showMessageDialog(null, "对不起，两次输入的密码不一致，请重新输入", "密码错误",JOptionPane.WARNING_MESSAGE);
                    oldPassword.setText("");
                    newPassword.setText("");
                }
            }
        });
    }
    public static void main(String[] args){
        new Mywork().setVisible(true);
    }

}