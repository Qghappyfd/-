/*
 * Created by JFormDesigner on Wed Jun 02 10:04:26 CST 2021
 */

package com.book.view;

import com.book.util.MusicUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;


/**
 * @author grimg
 */
public class MainFrm extends JFrame {
    MusicUtil play = null;
    public MainFrm() {
        initComponents();
    }

    /**
     * 查询按钮监听
     * @param e
     */
    private void QueryButtonActionPerformed(ActionEvent e) {
       QueryFrm queryFrm = new QueryFrm();
       queryFrm.setVisible(true);
    }
    /**
     * 添加按钮监听
     * @param e
     */
    private void AddButtonActionPerformed(ActionEvent e) {
        AddFrm addFrm = new AddFrm();
        addFrm.setVisible(true);
    }

    /**
     * 随机查询小练习按钮监听
     * @param e
     */
    private void RandomQuerybuttonActionPerformed(ActionEvent e) {
        PracticeChoiceFrm practiceChoiceFrm = new PracticeChoiceFrm();
        practiceChoiceFrm.setVisible(true);
    }

    /**
     * 安全退出
     * @param e
     */
    private void exitmenuItemActionPerformed(ActionEvent e) {
        int  result =JOptionPane.showConfirmDialog(null,"是否退出系统");
        if(result==0){
            dispose();
            System.exit(0);
        }
    }

    /**
     * 关于我们
     * @param e
     */

    private void AboutUsActionPerformed(ActionEvent e) {
        AboutUsFrm aboutUsFrm = new AboutUsFrm();
        aboutUsFrm.setVisible(true);
    }

    /**
     * 声音关闭
     * @param e
     */
    private void musicitemActionPerformed(ActionEvent e) {
        play.stop();
        System.out.println("1");
    }

    /**
     * 网络实验室按钮
     * @param e
     */
    private void InternetbuttonActionPerformed(ActionEvent e) {
        InternetFrm internetFrm = new InternetFrm();
        internetFrm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - grimg
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        exitmenuItem = new JMenuItem();
        menu3 = new JMenu();
        musicitem = new JMenuItem();
        menu2 = new JMenu();
        menuItem1 = new JMenuItem();
        QueryButton = new JButton();
        AddButton = new JButton();
        RandomQuerybutton = new JButton();
        Internetbutton = new JButton();

        //======== this ========
        setTitle("\u5355\u8bcd\u7c3f");
        setAutoRequestFocus(false);
        setResizable(false);
        setBackground(Color.black);
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u57fa\u672c\u6570\u636e\u7ef4\u62a4");
                menu1.setIcon(new ImageIcon(getClass().getResource("/images/\u6273\u624b (1).png")));

                //---- exitmenuItem ----
                exitmenuItem.setText("\u5b89\u5168\u9000\u51fa");
                exitmenuItem.addActionListener(e -> exitmenuItemActionPerformed(e));
                menu1.add(exitmenuItem);
            }
            menuBar1.add(menu1);

            //======== menu3 ========
            {
                menu3.setText("\u58f0\u97f3");
                menu3.setIcon(new ImageIcon(getClass().getResource("/images/\u58f0\u97f3.png")));

                //---- musicitem ----
                musicitem.setText("\u58f0\u97f3\u5173\u95ed");
                musicitem.setIcon(null);
                musicitem.addActionListener(e -> musicitemActionPerformed(e));
                menu3.add(musicitem);
            }
            menuBar1.add(menu3);

            //======== menu2 ========
            {
                menu2.setText("\u5173\u4e8e\u6211\u4eec");
                menu2.setIcon(new ImageIcon(getClass().getResource("/images/\u661f\u661f (1).png")));

                //---- menuItem1 ----
                menuItem1.setText("\u5173\u4e8e\u5f00\u53d1\u8005");
                menuItem1.addActionListener(e -> AboutUsActionPerformed(e));
                menu2.add(menuItem1);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //---- QueryButton ----
        QueryButton.setIcon(new ImageIcon(getClass().getResource("/images/\u67e5\u8be2.png")));
        QueryButton.setText("\u5355\u8bcd\u67e5\u8be2");
        QueryButton.setHorizontalTextPosition(SwingConstants.CENTER);
        QueryButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        QueryButton.setFont(QueryButton.getFont().deriveFont(Font.BOLD, QueryButton.getFont().getSize() + 13f));
        QueryButton.setBackground(Color.white);
        QueryButton.setBorderPainted(false);
        QueryButton.addActionListener(e -> QueryButtonActionPerformed(e));

        //---- AddButton ----
        AddButton.setBorderPainted(false);
        AddButton.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0.png")));
        AddButton.setText("\u5355\u8bcd\u6dfb\u52a0");
        AddButton.setHorizontalTextPosition(SwingConstants.CENTER);
        AddButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        AddButton.setFont(AddButton.getFont().deriveFont(AddButton.getFont().getStyle() | Font.BOLD, AddButton.getFont().getSize() + 13f));
        AddButton.setBackground(Color.white);
        AddButton.addActionListener(e -> AddButtonActionPerformed(e));

        //---- RandomQuerybutton ----
        RandomQuerybutton.setIcon(new ImageIcon(getClass().getResource("/images/\u7ec3\u4e60.png")));
        RandomQuerybutton.setHorizontalTextPosition(SwingConstants.CENTER);
        RandomQuerybutton.setVerticalTextPosition(SwingConstants.BOTTOM);
        RandomQuerybutton.setBackground(Color.white);
        RandomQuerybutton.setBorderPainted(false);
        RandomQuerybutton.setText("\u7ec3\u4e60\u6a21\u5f0f");
        RandomQuerybutton.setFont(RandomQuerybutton.getFont().deriveFont(RandomQuerybutton.getFont().getStyle() | Font.BOLD, RandomQuerybutton.getFont().getSize() + 13f));
        RandomQuerybutton.addActionListener(e -> RandomQuerybuttonActionPerformed(e));

        //---- Internetbutton ----
        Internetbutton.setIcon(new ImageIcon(getClass().getResource("/images/\u79d1\u6280.png")));
        Internetbutton.setBorderPainted(false);
        Internetbutton.setText("\u7f51\u7edc\u5b9e\u9a8c\u5ba4");
        Internetbutton.setFont(Internetbutton.getFont().deriveFont(Internetbutton.getFont().getStyle() | Font.BOLD, Internetbutton.getFont().getSize() + 13f));
        Internetbutton.setHorizontalTextPosition(SwingConstants.CENTER);
        Internetbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
        Internetbutton.setBackground(Color.white);
        Internetbutton.setBorder(null);
        Internetbutton.addActionListener(e -> InternetbuttonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(RandomQuerybutton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(QueryButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(AddButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Internetbutton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(AddButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(QueryButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(RandomQuerybutton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Internetbutton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(21, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        this.getContentPane().setBackground(Color.white);

        String rootPath = System.getProperty("user.dir").replace("\\", "/");
        rootPath+="/src/music/music.mp3";
        play = new MusicUtil(rootPath);
        play.start();  //开启


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            ////////////////
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - grimg
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem exitmenuItem;
    private JMenu menu3;
    private JMenuItem musicitem;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JButton QueryButton;
    private JButton AddButton;
    private JButton RandomQuerybutton;
    private JButton Internetbutton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
