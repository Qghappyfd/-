/*
 * Created by JFormDesigner on Wed Jun 02 18:55:34 CST 2021
 */

package com.book.view;

import java.awt.*;
import java.awt.event.*;
import com.book.dao.WordDao;
import com.book.util.sqlUtil;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * @author grimg
 */
public class RandomQueryFrm extends JFrame {
    sqlUtil Util = new sqlUtil();
    int cnt=0;
    public RandomQueryFrm() {
        initComponents();
    }

    /**
     * 重置按钮监听
     * @param e
     */
    private void button2ActionPerformed(ActionEvent e) {
        wordtxt.setText("");
    }

    /**
     * 提交按钮监听
     * @param e
     */
    private void SubmitButtonActionPerformed(ActionEvent e) {
        String answer = wordtxt.getText();
        PracticeFrm practiceFrm=new PracticeFrm(cnt,answer,0);
        this.setVisible(false);
        practiceFrm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        label1 = new JLabel();
        meaningtxt = new JTextField();
        label2 = new JLabel();
        wordtxt = new JTextField();
        SubmitButton = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u5c0f\u7ec3\u4e60");
        setResizable(false);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u91ca\u4e49\uff1a");

        //---- meaningtxt ----
        meaningtxt.setEditable(false);

        //---- label2 ----
        label2.setText("\u8bf7\u586b\u5199\u5bf9\u5e94\u5355\u8bcd");

        //---- SubmitButton ----
        SubmitButton.setText("\u63d0\u4ea4");
        SubmitButton.addActionListener(e -> SubmitButtonActionPerformed(e));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.addActionListener(e -> button2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                    .addGap(119, 119, 119))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(meaningtxt, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 45, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(wordtxt, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(SubmitButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap(6, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(meaningtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)
                    .addComponent(wordtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SubmitButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(51, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        randommeaning();




        this.getContentPane().setBackground(Color.white);////////////////
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JLabel label1;
    private JTextField meaningtxt;
    private JLabel label2;
    private JTextField wordtxt;
    private JButton SubmitButton;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    /**
     * 随机抽取释义
     */
    public void randommeaning(){
        ResultSet rs = null;
        ResultSet rs2 =null;
        Connection con = null;
        try {
            con = Util.createCon();
            rs =WordDao.Count(con);
            if(rs.next()){
                cnt = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            Util.close(rs);
        }
        try {
            con = Util.createCon();
            Random r = new Random();
            cnt = r.nextInt(cnt);
            rs2 = WordDao.RowQuery(con,cnt);
            if(rs2.next()){
                meaningtxt.setText(rs2.getString("meaning"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Util.close(rs2);
        }
    }

}
