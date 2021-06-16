/*
 * Created by JFormDesigner on Wed Jun 09 19:50:52 CST 2021
 */

package com.book.view;

import java.awt.*;
import java.awt.event.*;
import com.book.dao.WordDao;
import com.book.util.sqlUtil;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.lang.annotation.ElementType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

/**
 * @author grimg
 */
public class SingleChoiceQuestionFrm extends JFrame {
    ButtonGroup buttonGroup1= null;
    sqlUtil Util = new sqlUtil();
    int cnt = 0;
    int answer = 0;
    String meaning=null;
    int sum = 0;

    public SingleChoiceQuestionFrm() {
        initComponents();
    }


    /**
     * 英-中
     * @param e
     */
    private void SubmitbuttonActionPerformed(ActionEvent e) {
        String playeranswer =null;
        if(radioButton0.isSelected()) playeranswer = radioButton0.getText();
        if(radioButton1.isSelected()) playeranswer = radioButton1.getText();
        if(radioButton2.isSelected()) playeranswer = radioButton2.getText();
        if(radioButton3.isSelected()) playeranswer = radioButton3.getText();
        System.out.println(playeranswer);
        PracticeFrm practiceFrm=new PracticeFrm(cnt,playeranswer,1);
        this.setVisible(false);
        practiceFrm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        Wordtxt = new JTextField();
        radioButton0 = new JRadioButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        Submitbutton = new JButton();

        //======== this ========
        setResizable(false);
        setTitle("\u5c0f\u7ec3\u4e60");
        var contentPane = getContentPane();

        //---- radioButton0 ----
        radioButton0.setText("A.");
        radioButton0.setActionCommand("A");

        //---- radioButton1 ----
        radioButton1.setText("B.");
        radioButton1.setActionCommand("B");

        //---- radioButton2 ----
        radioButton2.setText("C.");
        radioButton2.setActionCommand("C");

        //---- radioButton3 ----
        radioButton3.setText("D.");
        radioButton3.setActionCommand("D");

        //---- Submitbutton ----
        Submitbutton.setText("\u63d0\u4ea4");
        Submitbutton.addActionListener(e -> SubmitbuttonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(Wordtxt, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(radioButton0, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(radioButton1, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(radioButton2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(radioButton3, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(177, 177, 177)
                            .addComponent(Submitbutton)))
                    .addContainerGap(99, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(Wordtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(radioButton0)
                    .addGap(18, 18, 18)
                    .addComponent(radioButton1)
                    .addGap(18, 18, 18)
                    .addComponent(radioButton2)
                    .addGap(18, 18, 18)
                    .addComponent(radioButton3)
                    .addGap(18, 18, 18)
                    .addComponent(Submitbutton)
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton0);
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents



        this.getContentPane().setBackground(Color.white);
        randomword();
        randomanswer();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JTextField Wordtxt;
    private JRadioButton radioButton0;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JButton Submitbutton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void randomword(){
        ResultSet rs = null;
        ResultSet rs2 =null;
        Connection con = null;
        try {
            con = Util.createCon();
            rs = WordDao.Count(con);
            if(rs.next()){
                cnt = rs.getInt(1);
                sum =cnt;
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
                Wordtxt.setText(rs2.getString("englishword"));
                meaning =rs2.getString("meaning");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Util.close(rs2);
        }
    }

    public void randomanswer(){
        Connection con =null;
        ResultSet rs= null;
        String unrelatedmeaning=null;
        Random r = new Random();
        answer= r.nextInt(4);
        List list = new ArrayList();
        list.add(cnt);
        switch(answer){
            case 0: radioButton0.setText(meaning);break;
            case 1: radioButton1.setText(meaning);break;
            case 2: radioButton2.setText(meaning);break;
            case 3: radioButton3.setText(meaning);break;
        }
        for(int i=0;i<4;i++){
            if(i==answer){
            }else{
                while(true) {
                    int t = r.nextInt(sum);
                    if(!list.contains(t)) {
                        list.add(t);
                        try {
                            con = Util.createCon();
                            rs = WordDao.RowQuery(con, t);
                            if (rs.next()) {
                                unrelatedmeaning = rs.getString("meaning");
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } finally {
                            Util.close(rs);
                        }
                        switch (i) {
                            case 0:
                                radioButton0.setText(unrelatedmeaning);
                                break;
                            case 1:
                                radioButton1.setText(unrelatedmeaning);
                                break;
                            case 2:
                                radioButton2.setText(unrelatedmeaning);
                                break;
                            case 3:
                                radioButton3.setText(unrelatedmeaning);
                                break;
                        }
                        break;
                    }
                }
            }
        }
    }
}
