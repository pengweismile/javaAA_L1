package com.allen.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDockerMysqlDocker  {
    private static final long serialVersionUID = 1L;

    private static String dburl, dbuser, dbpassword;

    static {
        dburl = "jdbc:mysql://192.168.0.100:3306/mysql";
        dbuser = "root";
        dbpassword = "123456";
    }

    public static void getDataVector() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        java.sql.Statement stmt = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
        stmt = conn.createStatement();
        String sql = "select * from Student";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println("Id:" + rs.getString("sid") +" | " + "name:"+ rs.getString("sname"));
        }
    }

    public static void main(String Args[]) throws ClassNotFoundException, SQLException {
        getDataVector();
    }
}
