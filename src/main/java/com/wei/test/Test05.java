package com.wei.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Test05 extends JFrame {

    //
    private JTextField titleTextField;
    private JTextField dateTextField;
    private JTextArea textArea;
    private final static String urlStr = "D:/MyLog/";
    private final static String todayDate =
            String.format("%tF", new Date());

    static {
        File file = new File(urlStr);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void main(String args[]) {
        try {
            Test05 frame = new Test05();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Test05() {
        super();
        //setTitle("11111");
        setBounds(100, 500, 500, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel softLabel = new JLabel();
        softLabel.setForeground(new Color(255, 0, 0));
        softLabel.setFont(new Font("", Font.BOLD, 22));
        softLabel.setHorizontalAlignment(SwingConstants.CENTER);
        softLabel.setText("日 志 薄");
        getContentPane().add(softLabel, BorderLayout.NORTH);

        final JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        final JPanel infoPanel = new JPanel();
        contentPanel.add(infoPanel, BorderLayout.CENTER);
        final JLabel titleLabel = new JLabel();
        titleLabel.setText("标 题：");
        infoPanel.add(titleLabel);


        titleTextField = new JTextField();
        titleTextField.setColumns(30);
        titleTextField.setText("请输入标题");
        titleTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                titleTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                String date = titleTextField.getText().trim();
                if (date.length() == 0) {
                    titleTextField.setText("请输入标题");
                }
            }
        });
        infoPanel.add(titleTextField);


        final JLabel dateLabel = new JLabel();
        dateLabel.setText("日 期:");
        infoPanel.add(dateLabel);
        dateTextField = new JTextField();
        dateTextField.setColumns(30);
        dateTextField.setText(todayDate);
        dateTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                dateTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                String date = dateTextField.getText().trim();
                if (date.length() != 10) {
                    dateTextField.setText(todayDate);
                }
            }
        });
        infoPanel.add(dateTextField);


        final JButton seeButton = new JButton();
        seeButton.setText("查看日志");
        seeButton.addActionListener(new SeeButtonActionListener());
        contentPanel.add(seeButton, BorderLayout.EAST);
        final JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.SOUTH);
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setRows(11);
        scrollPane.setViewportView(textArea);
        final JPanel buttonPanel = new JPanel();
        final FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(20);
        buttonPanel.setLayout(flowLayout);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        final JButton saveButton = new JButton();
        saveButton.setText("保存");
        saveButton.addActionListener(new SaveButtonActionListener());
        buttonPanel.add(saveButton);
        final JButton clearButton = new JButton();
        clearButton.setText("清空");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titleTextField.setText("请输入标题");
                dateTextField.setText(todayDate);
                textArea.setText("");
            }
        });
        buttonPanel.add(clearButton);
        final JButton exitButton = new JButton();
        exitButton.setText("退出");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);
    }

    public class SaveButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleTextField.getText();
            String date = dateTextField.getText();
            String name = title + "(" + date + ").text";
            File file = new File(urlStr + name);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(textArea.getText());
                fileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private class SeeButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Runtime.getRuntime().exec("notepad " + "D:\\MyLog\\" + titleTextField.getText() + "(" + dateTextField.getText() + ").text");
            } catch (IOException a) {

                a.printStackTrace();
            }//修改这里.txt为你自己的文本文件名
        }

        private File file = null;
        private File[] files = null;
        private File text = null;
        private JPanel allPanel;

        private class DelButtonActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                int index = Integer.valueOf(button.getName());
                files[index].delete();
                allPanel.remove(index);
                SwingUtilities.updateComponentTreeUI(allPanel);
            }
        }

        public File getText() {
            return text;
        }
    }
}
