/*
 * Created by JFormDesigner on Wed Jun 09 14:40:57 CST 2021
 */

package com.book.view;

import com.book.lab.SearchWord;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author grimg
 */
public class InternetQueryFrm extends JFrame {
    public InternetQueryFrm() {
        initComponents();
    }

    private void QueryButtonActionPerformed(ActionEvent e) {
        Map<String,String> params = new HashMap<String,String>();
        String q = Wordtxt.getText();
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("from", "auto");
        params.put("to", "auto");
        params.put("signType", "v3");
        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
        params.put("curtime", curtime);
        String signStr = SearchWord.getAppKey() + SearchWord.truncate(q) + salt + curtime + SearchWord.getAppSecret();
        String sign = SearchWord.getDigest(signStr);
        params.put("appKey", SearchWord.getAppKey());
        params.put("q", q);
        params.put("salt", salt);
        params.put("sign", sign);
        params.put("vocabId","您的用户词表ID");
        /** 处理结果 */
        try {
            String str=SearchWord.requestForHttp(SearchWord.getYoudaoUrl(),params);
            MeaningTxt.setText(str);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        Wordtxt = new JTextField();
        QueryButton = new JButton();
        scrollPane1 = new JScrollPane();
        MeaningTxt = new JTextArea();
        tree1 = new JTree();

        //======== this ========
        setResizable(false);
        setTitle("\u7f51\u7edc\u67e5\u8be2");
        var contentPane = getContentPane();

        //---- QueryButton ----
        QueryButton.setIcon(new ImageIcon(getClass().getResource("/images/\u67e5\u8be2 2.png")));
        QueryButton.addActionListener(e -> QueryButtonActionPerformed(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(MeaningTxt);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(Wordtxt, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(QueryButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(32, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(QueryButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Wordtxt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.getContentPane().setBackground(Color.white);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JTextField Wordtxt;
    private JButton QueryButton;
    private JScrollPane scrollPane1;
    private JTextArea MeaningTxt;
    private JTree tree1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
