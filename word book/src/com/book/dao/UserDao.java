package com.book.dao;

import com.book.model.User;
import com.book.util.sqlUtil;

import java.sql.*;

/**
 * 登录验证
 * 成功返回User对象，失败返回空
 */
public class UserDao {
    public User login(Connection con, User user){
        sqlUtil util  =  new sqlUtil();
        ResultSet result = null;
        User resultUser=null;
        String sql="select * from user where userName=? and password =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            result = ps.executeQuery();
            if(result.next()){
                resultUser = new User();
                resultUser.setId(result.getInt("id"));
                resultUser.setUserName(result.getString("userName"));
                resultUser.setPassword(result.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            util.close(result);
        }
        return resultUser;
    }
}
