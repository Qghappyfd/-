/*
 * Created by JFormDesigner on Wed Jun 02 18:51:02 CST 2021
 */

package com.book.view;

import com.book.dao.WordDao;
import com.book.model.Word;
import com.book.util.sqlUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.lang.model.element.NestingKind;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author grimg
 */
public class AddFrm extends JFrame {
    sqlUtil Util = new sqlUtil();
    public AddFrm() {
        initComponents();
    }

    /**
     * 添加按钮的监听
     * @param e
     */
    private void AddbuttonActionPerformed(ActionEvent e) {
        Word word = new Word();
        word.setEnglishword(englishwordtxt.getText());
        word.setMeaning(meaningtxt.getText());
        word.setExample(exampletxt.getText());
        Connection con =null;
        try {
            con = Util.createCon();
            WordDao.AddWord(con,word);
            JOptionPane.showMessageDialog(null, "添加成功");
            englishwordtxt.setText("");
            meaningtxt.setText("");
            exampletxt.setText("");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "添加失败");
        } finally{
            Util.close();
        }
    }

    /**
     * 重置按钮监听
     * @param e
     */
    private void resetbuttonActionPerformed(ActionEvent e) {
        englishwordtxt.setText("");
        meaningtxt.setText("");
        exampletxt.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        label1 = new JLabel();
        englishwordtxt = new JTextField();
        label2 = new JLabel();
        meaningtxt = new JTextField();
        label3 = new JLabel();
        Addbutton = new JButton();
        resetbutton = new JButton();
        scrollPane1 = new JScrollPane();
        exampletxt = new JTextArea();

        //======== this ========
        setTitle("\u5355\u8bcd\u6dfb\u52a0");
        setResizable(false);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5355\u8bcd:");

        //---- label2 ----
        label2.setText("\u91ca\u4e49\uff1a");

        //---- label3 ----
        label3.setText("\u4f8b\u53e5\uff1a");

        //---- Addbutton ----
        Addbutton.setText("\u6dfb\u52a0");
        Addbutton.addActionListener(e -> AddbuttonActionPerformed(e));

        //---- resetbutton ----
        resetbutton.setText("\u91cd\u7f6e");
        resetbutton.addActionListener(e -> resetbuttonActionPerformed(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(exampletxt);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(Addbutton)
                            .addGap(94, 94, 94)
                            .addComponent(resetbutton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(meaningtxt, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(englishwordtxt, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))))
                    .addGap(55, 55, 55))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(englishwordtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(meaningtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addGap(18, 18, 18)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Addbutton)
                        .addComponent(resetbutton))
                    .addGap(39, 39, 39))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.getContentPane().setBackground(Color.white);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JLabel label1;
    private JTextField englishwordtxt;
    private JLabel label2;
    private JTextField meaningtxt;
    private JLabel label3;
    private JButton Addbutton;
    private JButton resetbutton;
    private JScrollPane scrollPane1;
    private JTextArea exampletxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
