package com.book.dao;

import com.book.model.User;
import com.book.model.Word;
import com.book.util.StringUtil;
import com.book.util.sqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class WordDao {

    public static PreparedStatement AddWord(Connection con, Word word) throws SQLException {
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = con.prepareStatement("insert into word value(null,?,?,?)");
        ps.setString(1,word.getEnglishword());
        ps.setString(2, word.getMeaning());
        ps.setString(3,word.getExample());
        int r=ps.executeUpdate();
        System.out.println(r==1?"添加成功":"添加失败");
        return ps;
    }

    public static PreparedStatement DelWord(Connection con,Word word) throws SQLException {
        PreparedStatement ps = con.prepareStatement("delete from word where id =?");
        ps.setInt(1,word.getId());
        int r=ps.executeUpdate();
        System.out.println(r==1?"删除成功":"删除失败");
        return ps;
    }

    public static PreparedStatement UpdateWord(Connection con,Word word) throws SQLException {
        PreparedStatement ps=con.prepareStatement("update word set englishword=?,meaning = ?,example=? where id=?");
        ps.setString(1,word.getEnglishword());
        ps.setString(2,word.getMeaning());
        ps.setString(3,word.getExample());
        ps.setInt(4,word.getId());
        int r=ps.executeUpdate();
        System.out.println(r==1?"更新成功":"更新失败");
        return ps;
    }

    public static ResultSet RegexQueryWord(Connection con, Word word) throws SQLException {
        StringBuffer sb = new StringBuffer("select * from word");
        if(!StringUtil.isEmpty(word.getEnglishword())){
            sb.append(" and englishword regexp '"+word.getEnglishword()+"'");
        }
        PreparedStatement ps = con.prepareStatement(sb.toString().replaceFirst("and","where"));
        ResultSet re = ps.executeQuery();
        return re;
    }

    public static ResultSet QueryWord(Connection con, Word word) throws SQLException {
        StringBuffer sb = new StringBuffer("select * from word");
        if(!StringUtil.isEmpty(word.getEnglishword())){
            sb.append(" and englishword like '%"+word.getEnglishword()+"%'");
        }
        PreparedStatement ps = con.prepareStatement(sb.toString().replaceFirst("and","where"));
        ResultSet re = ps.executeQuery();
        return re;
    }

    public static ResultSet Queryid(Connection con, Word word) throws SQLException {
        PreparedStatement ps = con.prepareStatement("select * from word where id =?");
        ps.setInt(1,word.getId());
        ResultSet re = ps.executeQuery();
        return re;
    }

    public static ResultSet Count(Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement("select count(*) from word");
        ResultSet re = ps.executeQuery();
        return re;
    }

    public static ResultSet RowQuery(Connection con,int row) throws SQLException {

        PreparedStatement ps = con.prepareStatement("select * from word limit ?,1");
        ps.setInt(1,row);
        ResultSet re = ps.executeQuery();
        return re;
    }
}
