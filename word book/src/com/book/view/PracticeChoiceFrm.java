/*
 * Created by JFormDesigner on Wed Jun 09 21:19:55 CST 2021
 */

package com.book.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author grimg
 */
public class PracticeChoiceFrm extends JFrame {
    public PracticeChoiceFrm() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        this.setVisible(false);
        SingleChoiceQuestionFrm singleChoiceQuestionFrm=new SingleChoiceQuestionFrm();
        singleChoiceQuestionFrm.setVisible(true);
    }

    private void button2ActionPerformed(ActionEvent e) {
        this.setVisible(false);
        RandomQueryFrm randomQueryFrm = new RandomQueryFrm();
        randomQueryFrm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("\u7ec3\u4e60\u6a21\u5f0f");
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("\u82f1-\u4e2d");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 10f));
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u82f1\u8bd1\u4e2d.png")));
        button1.setHorizontalTextPosition(SwingConstants.CENTER);
        button1.setVerticalTextPosition(SwingConstants.BOTTOM);
        button1.setBackground(Color.white);
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("\u4e2d-\u82f1");
        button2.setIcon(new ImageIcon(getClass().getResource("/images/\u4e2d\u8bd1\u82f1.png")));
        button2.setHorizontalTextPosition(SwingConstants.CENTER);
        button2.setVerticalTextPosition(SwingConstants.BOTTOM);
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getStyle() & ~Font.BOLD, button2.getFont().getSize() + 10f));
        button2.setBackground(Color.white);
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u5206\u5c94\u8def (3).png")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(183, 183, 183)
                    .addComponent(label1)
                    .addContainerGap(202, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(38, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label1)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        this.getContentPane().setBackground(Color.white);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
