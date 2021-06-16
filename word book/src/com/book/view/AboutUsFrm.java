/*
 * Created by JFormDesigner on Fri Jun 04 10:39:26 CST 2021
 */

package com.book.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author grimg
 */
public class AboutUsFrm extends JFrame {
    public AboutUsFrm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setTitle("\u5173\u4e8e\u521b\u4f5c\u56e2\u961f");
        setIconImage(new ImageIcon(getClass().getResource("/images/s.jpg")).getImage());
        setBackground(new Color(0, 204, 204));
        setResizable(false);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u521b\u4f5c\u4eba\u5458\uff1a \u80e1\u4f1f\u5065 \u3001\u9f9a\u6587\u6d9b\u3001 \u65b9\u680b");
        label1.setBackground(new Color(0, 204, 204));

        //---- label2 ----
        label2.setIcon(new ImageIcon(getClass().getResource("/images/20201226122404_b7e3a (1).jpg")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(108, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
                    .addGap(73, 73, 73))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.getContentPane().setBackground(Color.white);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
