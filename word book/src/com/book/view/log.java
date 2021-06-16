package com.book.view;

import com.book.dao.UserDao;
import com.book.model.User;
import com.book.util.StringUtil;
import com.book.util.sqlUtil;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class log {

    private JFrame frame;
    private JPanel panel1;
    private JTextField userNameTxt;
    private JButton resetButton;
    private JButton loginButton;
    private JPasswordField passwordTxt;


    private sqlUtil dbUtil = new sqlUtil();
    private UserDao userDao = new UserDao();


    public static void Initsql(){
        FileInputStream fis = null;
        Statement stmt=null;
        ResultSet rs=null;
        Connection con =null;
        try {
            String rootPath = System.getProperty("user.dir").replace("\\", "/");
            rootPath+="/userlog.txt";

            fis = new FileInputStream(rootPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String user=br.readLine().split("=")[1].trim();
            String password=br.readLine().split("=")[1].trim();
            String url="jdbc:mysql://localhost/mysql?useSSL = false&serverTimezone = UTC&allowPublicKeyRetrieval=true";
            con= DriverManager.getConnection(url,user,password);

            String checkdatabase="show databases like \"book\"";
            String createdatabase="create  database  book";
            stmt=  con.createStatement();
            rs=stmt.executeQuery(checkdatabase);
            if (!rs.next())
            {
                stmt.executeUpdate(createdatabase);
                url="jdbc:mysql://localhost/book?useSSL = false&serverTimezone = UTC&allowPublicKeyRetrieval=true";
                con=DriverManager.getConnection(url,user,password);
                stmt=con.createStatement();
                String sql1="CREATE TABLE `user`  (" +
                        "  `id` int(11) NOT NULL AUTO_INCREMENT," +
                        "  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL," +
                        "  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL," +
                        "  PRIMARY KEY (`id`) USING BTREE" +
                        ") ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;";
                String sql2="INSERT INTO `user` VALUES (1, 'admin', '123');";
                String sql3="CREATE TABLE `word`  (" +
                        "  `id` int(11) NOT NULL AUTO_INCREMENT," +
                        "  `englishword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL," +
                        "  `meaning` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL," +
                        "  `example` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL," +
                        "  PRIMARY KEY (`id`) USING BTREE" +
                        ") ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;";
                String sql4="INSERT INTO `word` VALUES (1, 'example', '示例','his courage is an example to us');";
                stmt.executeUpdate(sql1);
                stmt.executeUpdate(sql2);
                stmt.executeUpdate(sql3);
                stmt.executeUpdate(sql4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection对象创建失败");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public log() {



        this.frame = new JFrame("用户登录");
        frame.setResizable(false);                  //取消窗体的最大化按钮
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.getContentPane().setBackground(Color.white);

//        //设置大小
//        this.frame.setSize(10, 400);
//        //设置位置
//        this.frame.setLocation(200, 50);
//        //背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
//        String path = "src/images/s.jpg";
//        // 背景图片
//        ImageIcon background = new ImageIcon(path);
//        // 把背景图片显示在一个标签里面
//        JLabel label = new JLabel(background);
//        // 把标签的大小位置设置为图片刚好填充整个面板
//        label.setBounds(0, 0, this.frame.getWidth(), this.frame.getHeight());
//        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
//        JPanel imagePanel = (JPanel) this.frame.getContentPane();
//        imagePanel.setOpaque(false);
//        // 把背景图片添加到分层窗格的最底层作为背景
//        this.frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));



//        this.panel1.setLayout(new BorderLayout());
//        ImageIcon background = new ImageIcon("src/images/s.jpg");
//        JLabel label=new JLabel(background);
//        this.panel1.add("Center", label);

 //       loginButton.setIcon(background);
        frame.setVisible(true);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAction(e);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonActon(e);
            }
        });
        this.frame.setLocationRelativeTo(null);
    }

    /**
     * 创建登录事件
     *
     * @return void
     */
    private void loginButtonActon(ActionEvent evt) {
        String userName = this.userNameTxt.getText();
        String password = new String(this.passwordTxt.getPassword());
        if (StringUtil.isEmpty(userName)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
        }
        else if (StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
        }
        User user = new User(userName, password);
        Connection conn = null;
        try {
            conn = dbUtil.createCon();
            User currentUser = userDao.login(conn, user);
            if (currentUser != null) {
                this.frame.setVisible(false);
                new MainFrm().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 重置事件处理
     *
     * @return void
     */
    private void resetAction(ActionEvent evt) {
        this.userNameTxt.setText("");
        this.passwordTxt.setText("");
    }

    public static void main(String[] args) throws Exception {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        Initsql();
        new log();
    }

    public void setIcon(String file, JButton iconButton) {
        ImageIcon icon = new ImageIcon(file);
        Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
                iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
        iconButton.setIcon(icon);
    }


}
