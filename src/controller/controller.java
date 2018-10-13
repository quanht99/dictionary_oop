package controller;

import Connection.connectWithDatabase;

import java.sql.*;
import java.util.ArrayList;

public class controller {

    //seach tu
    public static String findWord(String text) throws SQLException {
        Connection conn = connectWithDatabase.getConnection();
        assert conn != null;
        Statement stmt = conn.createStatement();
        String sql = "select detail from dictionary where word = ?";

        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, text);
            ResultSet rs = pstm.executeQuery();
            String Detail = "";
            while(rs.next()){
                Detail = rs.getString("detail");
            }
            rs.close();
            stmt.close();
            conn.close();
            return Detail;
        }
        catch (Exception e){
            System.out.println(e);
            return "";
        }
    }

    //Goi y
    public static String[] suggestionWord(String text) throws SQLException {
        ArrayList<String> list = new ArrayList<String>();

        Connection conn = connectWithDatabase.getConnection();
        assert conn != null;
        String sql = "select word from dictionary where word like ? limit ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,  "%" + text + "%");
            pstm.setInt(2, 50);
            System.out.println(sql);

            ResultSet rs = pstm.executeQuery();
            int i=0;
            while(rs.next()){
               String test = rs.getString("word");
               if(text != null){
                   list.add(test);
               }
               else{
                   break;
               }
                i++;
            }
            int k=0;
            int length = list.size();
            String[] result = new String[length];
            for(k=0; k<i; k++){
                result[k] = list.get(k);
            }
            return result;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
