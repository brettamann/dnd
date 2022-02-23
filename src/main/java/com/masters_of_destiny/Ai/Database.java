package com.masters_of_destiny.Ai;

import java.sql.*;

public class Database {
    public void connectToAndQueryDatabase(String username, String password) {
        try {
            Connection con = DriverManager.getConnection("jdbc:myDriver:myDatabase");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");
            while (rs.next()) {
                int x = rs.getInt("a");
                String s = rs.getString("b");
                float f = rs.getFloat("c");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
