/*
 * Created by JFormDesigner on Tue Jun 08 22:14:56 CST 2021
 */

package com.book.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author grimg
 */
public class InternetFrm extends JFrame {
    public InternetFrm() {
        initComponents();
    }


    private void button2ActionPerformed(ActionEvent e) {
        TextTranslationFrm textTranslationFrm =new TextTranslationFrm();
        textTranslationFrm.setVisible(true);
    }
    /**
     * 联网查询
     * @param e
     */

    private void button1ActionPerformed(ActionEvent e) {
        InternetQueryFrm internetQueryFrm =new InternetQueryFrm();
        internetQueryFrm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        button2 = new JButton();
        button3 = new JButton();
        button1 = new JButton();

        //======== this ========
        setResizable(false);
        setTitle("\u7f51\u7edc\u5b9e\u9a8c\u5ba4");
        var contentPane = getContentPane();

        //---- button2 ----
        button2.setText("\u6587\u672c\u7ffb\u8bd1");
        button2.setIcon(new ImageIcon(getClass().getResource("/images/\u7ffb\u8bd1.png")));
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 8f));
        button2.setBackground(Color.white);
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("\u656c\u8bf7\u671f\u5f85");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 8f));
        button3.setBackground(Color.white);

        //---- button1 ----
        button1.setText("\u8054\u7f51\u67e5\u8be2");
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u4e92\u8054\u7f51.png")));
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 8f));
        button1.setBackground(Color.white);
        button1.addActionListener(e -> button1ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(button1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(48, 48, 48))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents



        this.getContentPane().setBackground(Color.white);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JButton button2;
    private JButton button3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
