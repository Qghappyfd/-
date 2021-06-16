/*
 * Created by JFormDesigner on Wed Jun 02 20:58:43 CST 2021
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

/**
 * @author grimg
 */
public class PracticeFrm extends JFrame {
    sqlUtil Util = new sqlUtil();
    int flag = 0;
    public PracticeFrm(int cnt,String answer,int flag) {
        this.flag = flag;
        initComponents(cnt,answer,flag);
    }

    /**
     * 再一次按钮监听
     * @param e
     */
    private void AgainButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
        if(flag==0){
            RandomQueryFrm randomQueryFrm = new RandomQueryFrm();
            randomQueryFrm.setVisible(true);
        }else {
           SingleChoiceQuestionFrm singleChoiceQuestionFrm = new SingleChoiceQuestionFrm();
           singleChoiceQuestionFrm.setVisible(true);
        }
    }

    private void CloseButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void initComponents(int cnt,String answer,int flag) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        text1 = new JTextField();
        text2 = new JTextField();
        label1 = new JLabel();
        englishwordtxt = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        meaningtxt = new JTextField();
        exampletxt = new JTextField();
        AgainButton = new JButton();
        CloseButton = new JButton();

        //======== this ========
        setResizable(false);
        setTitle("\u5c0f\u7ec3\u4e60");
        var contentPane = getContentPane();

        //---- text1 ----
        text1.setEditable(false);

        //---- text2 ----
        text2.setEditable(false);

        //---- label1 ----
        label1.setText("\u5355\u8bcd\uff1a");

        //---- englishwordtxt ----
        englishwordtxt.setEditable(false);

        //---- label2 ----
        label2.setText("\u91ca\u4e49\uff1a");

        //---- label3 ----
        label3.setText("\u4f8b\u53e5:");

        //---- meaningtxt ----
        meaningtxt.setEditable(false);

        //---- exampletxt ----
        exampletxt.setEditable(false);

        //---- AgainButton ----
        AgainButton.setText("\u518d\u8bd5\u4e00\u6b21");
        AgainButton.addActionListener(e -> AgainButtonActionPerformed(e));

        //---- CloseButton ----
        CloseButton.setText("\u5173\u95ed");
        CloseButton.addActionListener(e -> CloseButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(text1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                        .addComponent(text2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(183, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(97, 97, 97)
                            .addComponent(AgainButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                            .addComponent(CloseButton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(89, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(englishwordtxt, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                .addComponent(exampletxt, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                .addComponent(meaningtxt, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))))
                    .addContainerGap(82, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(text1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(text2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(englishwordtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(14, 14, 14)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(meaningtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(exampletxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(AgainButton)
                        .addComponent(CloseButton))
                    .addContainerGap(40, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.getContentPane().setBackground(Color.white);
        mate(cnt,answer,flag);   //匹配
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JTextField text1;
    private JTextField text2;
    private JLabel label1;
    private JTextField englishwordtxt;
    private JLabel label2;
    private JLabel label3;
    private JTextField meaningtxt;
    private JTextField exampletxt;
    private JButton AgainButton;
    private JButton CloseButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    /**
     * 匹配程序
     */
    public void mate(int cnt ,String answer,int flag){
        Connection con = null;
        ResultSet rs = null;
        String word=null;
        String word2 =null;
        try {
            con = Util.createCon();
            rs = WordDao.RowQuery(con,cnt);
            if(rs.next()){
                word = rs.getString("englishword");
                word2 = rs.getString("meaning");
                System.out.println(word2);///////
                englishwordtxt.setText(word);
                meaningtxt.setText(rs.getString("meaning"));
                exampletxt.setText(rs.getString("example"));
            }
            if(flag==0) {
                if (word.equals(answer)) {
                    text1.setText("恭喜你，");
                    text2.setText("答对了！");
                } else {
                    text1.setText("很遗憾，");
                    text2.setText("答错了！");
                }
            }else{
                if (word2.equals(answer)) {
                    text1.setText("恭喜你，");
                    text2.setText("答对了！");
                } else {
                    text1.setText("很遗憾，");
                    text2.setText("答错了！");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            Util.close(rs);
        }
    }
}
