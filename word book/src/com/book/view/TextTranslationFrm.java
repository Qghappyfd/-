/*
 * Created by JFormDesigner on Wed Jun 09 21:42:14 CST 2021
 */

package com.book.view;

import com.book.lab.SearchWord;

import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author grimg
 */
public class TextTranslationFrm extends JFrame {
    public TextTranslationFrm() {
        initComponents();
    }

    private void TranslationbuttonActionPerformed(ActionEvent e) {
        Map<String,String> params = new HashMap<String,String>();
        String q = wordtxt.getText();
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
            String str=SearchWord.requestForHttp2(SearchWord.getYoudaoUrl(),params);
            answertxt.setText(str);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        scrollPane1 = new JScrollPane();
        wordtxt = new JTextArea();
        scrollPane2 = new JScrollPane();
        answertxt = new JTextArea();
        Translationbutton = new JButton();

        //======== this ========
        setResizable(false);
        setTitle("\u6587\u672c\u7ffb\u8bd1");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(wordtxt);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(answertxt);
        }

        //---- Translationbutton ----
        Translationbutton.setText("\u7ffb\u8bd1");
        Translationbutton.addActionListener(e -> TranslationbuttonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane2))
                    .addContainerGap(44, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(202, 202, 202)
                    .addComponent(Translationbutton)
                    .addContainerGap(208, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(Translationbutton)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JScrollPane scrollPane1;
    private JTextArea wordtxt;
    private JScrollPane scrollPane2;
    private JTextArea answertxt;
    private JButton Translationbutton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
