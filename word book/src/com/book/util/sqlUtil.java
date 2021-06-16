package com.book.util;
import java.io.*;
import java.sql.*;
import java.util.ResourceBundle;

public class sqlUtil {
    private Connection con=null;
    private PreparedStatement ps =null;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Driver接口实现类完成注册");
    }

    //封装Connection
    public Connection createCon(){
        FileInputStream fis = null;
        try {
            String rootPath = System.getProperty("user.dir").replace("\\", "/");
            rootPath+="/userlog.txt";

            fis = new FileInputStream(rootPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String user=br.readLine().split("=")[1].trim();
            String password=br.readLine().split("=")[1].trim();
            String url="jdbc:mysql://localhost/book?useSSL = false&serverTimezone = UTC&allowPublicKeyRetrieval=true";
            con=DriverManager.getConnection(url,user,password);

            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","903305");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection对象创建失败");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    //封装PreparedStatement
    public PreparedStatement createStatement(String sql){
        try {
            ps = createCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    //通道关闭

    public void close(){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }

}
