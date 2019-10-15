package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ticks {

    public static void createTable(Statement stmt) throws SQLException{
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
    }

    public static void createTick(Statement stmt) throws SQLException{
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
    }

    public static ArrayList<String> getTicks(Connection con) throws SQLException{
        Statement stmt = con.createStatement();
        Ticks.createTable(stmt);
        Ticks.createTick(stmt);
  
        ArrayList<String> output = new ArrayList<String>();
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
        while (rs.next()) {
            output.add("Read from DB: " + rs.getTimestamp("tick"));
        }
        return output;
    }

}