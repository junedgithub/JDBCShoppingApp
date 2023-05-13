package ShoppingApp;

import java.sql.*;

public class DisplayCartProduct {
    public static void displayProduct()
    {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select * from cart";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("NAME\t\tQTY\t\tPRICE");
            System.out.println("==================================================================");
            while (rs.next())
            {
                String name = rs.getString(1);
                int  qty = rs.getInt(2);
                double price = rs.getDouble(3);
                System.out.println(name+"\t\t"+qty+"\t\t"+price);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (con!=null)
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs!=null)
            {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
