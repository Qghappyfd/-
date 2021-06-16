/*
 * Created by JFormDesigner on Wed Jun 02 14:58:00 CST 2021
 */

package com.book.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import com.book.dao.WordDao;
import com.book.model.Word;
import com.book.util.sqlUtil;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

/**
 * @author grimg
 */
public class QueryFrm extends JFrame {
    sqlUtil Util = new sqlUtil();

    public QueryFrm() {
        initComponents();
    }

    /**
     * 查询按钮监听
     * @param e
     */
    private void QuerybuttonActionPerformed(ActionEvent e) {
        String str =this.wordQueryTxt.getText();

        Word word = new Word();
        word.setEnglishword(str);

        this.fillTable(word);
    }

    /**
     * wordtable的鼠标点击事件
     * @param e
     */
    private void wordTableMousePressed(MouseEvent e) {
        int row = wordTable.getSelectedRow();
            idtxt.setText(wordTable.getValueAt(row, 0).toString());
            englishwordtxt.setText((String) wordTable.getValueAt(row, 1));
            meaningtxt.setText((String) wordTable.getValueAt(row, 2));
            Connection con = null;
            ResultSet rs =null;
            Word word = new Word();
            word.setId(Integer.valueOf(idtxt.getText()));
            try {
                con=Util.createCon();
                rs =WordDao.Queryid(con,word);
                if(rs.next()) {
                    exampletxt.setText(rs.getString("example"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                Util.close(rs);
            }
    }

    /**
     * 更新按钮监听
     * @param e
     */
    private void updatebuttonActionPerformed(ActionEvent e) {
        Word word = new Word();
        word.setId(Integer.valueOf(idtxt.getText()));
        word.setEnglishword(englishwordtxt.getText());
        word.setMeaning(meaningtxt.getText());
        word.setExample(exampletxt.getText());
        Connection con = null;
        try {
            con =Util.createCon();
            WordDao.UpdateWord(con,word);
            this.fillTable(new Word());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            Util.close();
        }
    }

    /**
     * 删除按钮监听
     * @param e
     */
    private void delbuttonActionPerformed(ActionEvent e) {
        Word word = new Word();
        if(idtxt.getText()!=null) {
            word.setId(Integer.valueOf(idtxt.getText()));
            Connection con = null;
            try {
                con = Util.createCon();
                WordDao.DelWord(con, word);
                idtxt.setText("");
                englishwordtxt.setText("");
                meaningtxt.setText("");
                exampletxt.setText("");
                this.fillTable(new Word());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                Util.close();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        scrollPane1 = new JScrollPane();
        wordTable = new JTable();
        label1 = new JLabel();
        wordQueryTxt = new JTextField();
        Querybutton = new JButton();
        panel1 = new JPanel();
        label2 = new JLabel();
        idtxt = new JTextField();
        label3 = new JLabel();
        englishwordtxt = new JTextField();
        label4 = new JLabel();
        meaningtxt = new JTextField();
        label5 = new JLabel();
        scrollPane2 = new JScrollPane();
        exampletxt = new JTextArea();
        updatebutton = new JButton();
        delbutton = new JButton();
        regexradioButton = new JRadioButton();

        //======== this ========
        setTitle("\u5355\u8bcd\u67e5\u8be2\u9875\u9762");
        setResizable(false);
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- wordTable ----
            wordTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u7f16\u53f7", "\u5355\u8bcd", "\u91ca\u4e49"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            wordTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    wordTableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(wordTable);
        }

        //---- label1 ----
        label1.setText("\u5355\u8bcd\u67e5\u8be2\uff1a");

        //---- Querybutton ----
        Querybutton.setText("\u67e5\u8be2");
        Querybutton.addActionListener(e -> QuerybuttonActionPerformed(e));

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u5355\u8bcd\u64cd\u4f5c"));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label2 ----
            label2.setText("\u7f16\u53f7\uff1a");
            label2.setEnabled(false);

            //---- idtxt ----
            idtxt.setEditable(false);

            //---- label3 ----
            label3.setText("\u5355\u8bcd\uff1a");
            label3.setEnabled(false);

            //---- label4 ----
            label4.setText("\u91ca\u4e49\uff1a");
            label4.setEnabled(false);

            //---- label5 ----
            label5.setText("\u4f8b\u53e5\uff1a");
            label5.setEnabled(false);

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(exampletxt);
            }

            //---- updatebutton ----
            updatebutton.setText("\u4fee\u6539");
            updatebutton.addActionListener(e -> updatebuttonActionPerformed(e));

            //---- delbutton ----
            delbutton.setText("\u5220\u9664");
            delbutton.addActionListener(e -> delbuttonActionPerformed(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label4)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(idtxt, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(englishwordtxt))
                                    .addComponent(meaningtxt)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label5)
                                .addGap(20, 20, 20)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(scrollPane2)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(updatebutton)
                                        .addGap(63, 63, 63)
                                        .addComponent(delbutton)
                                        .addGap(56, 56, 56)))))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(label3)
                            .addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(englishwordtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(meaningtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(updatebutton)
                                    .addComponent(delbutton))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            );
        }

        //---- regexradioButton ----
        regexradioButton.setText("\u6b63\u5219\u67e5\u8be2");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(regexradioButton)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(wordQueryTxt, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Querybutton))))
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(79, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Querybutton)
                        .addComponent(label1)
                        .addComponent(wordQueryTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(regexradioButton)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        /**
         * 初始化 wordtable
         */
        this.fillTable2(new Word());
        this.getContentPane().setBackground(Color.white);
        panel1.setBackground(Color.white);
        //wordTable.setRowSelectionInterval(0,0);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JScrollPane scrollPane1;
    private JTable wordTable;
    private JLabel label1;
    private JTextField wordQueryTxt;
    private JButton Querybutton;
    private JPanel panel1;
    private JLabel label2;
    private JTextField idtxt;
    private JLabel label3;
    private JTextField englishwordtxt;
    private JLabel label4;
    private JTextField meaningtxt;
    private JLabel label5;
    private JScrollPane scrollPane2;
    private JTextArea exampletxt;
    private JButton updatebutton;
    private JButton delbutton;
    private JRadioButton regexradioButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    private void fillTable2(Word word){
        DefaultTableModel dtm = (DefaultTableModel) wordTable.getModel();
        dtm.setRowCount(0);                                       ////////////////////////
        Connection con =null;
        ResultSet rs = null;
        try {
            con =Util.createCon();
            rs=WordDao.QueryWord(con,word);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt("id"));
                v.add(rs.getString("englishword"));
                v.add(rs.getString("meaning"));
                dtm.addRow(v);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            Util.close(rs);                           ///////////////
        }
    }
    private void fillTable(Word word){
        boolean flag=regexradioButton.isSelected();

        Vector<Vector> s = new Vector<>();

        DefaultTableModel dtm = (DefaultTableModel) wordTable.getModel();
        dtm.setRowCount(0);
        Connection con =null;
        ResultSet rs = null;
        try {
            con =Util.createCon();
            if(!flag) {
                rs = WordDao.QueryWord(con, word);
            }else{
                rs = WordDao.RegexQueryWord(con,word);
            }

            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt("id"));
                v.add(rs.getString("englishword"));
                v.add(rs.getString("meaning"));
                s.add(v);
            }


            Collections.sort(s, (a, b) -> {
                int s1=a.get(1).toString().length();
                int s2=b.get(1).toString().length();
                return s1-s2;
            });


            for(Vector t:s)
            {
                dtm.addRow(t);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            Util.close(rs);
        }
    }
}
