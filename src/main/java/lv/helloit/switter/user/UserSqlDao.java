package lv.helloit.switter.user;

import java.sql.*;

public class UserSqlDao {
    static final String DB_URL = "jdbc:postgresql://ec2-54-247-181-232.eu-west-1.compute.amazonaws.com:5432/ddlvu5pf94g6u3";
    static final String DB_USER = "ubtflmsvlsvcla";
    static final String DB_PASSWORD = "b874bc49a245517ecaf7de62b7fd42bde8e08a445eef647e20804376ca045bd9";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM \"SWIT\"");

            while(rs.next()){
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("content"));
                System.out.println(rs.getString("publishdate"));
                System.out.println(rs.getString("userid"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (NullPointerException | SQLException e) {
                System.out.println("Already closed");
            }
        }
    }
}
