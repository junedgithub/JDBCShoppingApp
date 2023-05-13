package ShoppingApp;

import java.sql.*;

public class RemoveItemFromCart {
    public static void removeItem(String name){

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "delete from cart where name = '"+name+"'";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            stmt = con.createStatement();
            int count = stmt.executeUpdate(query);
            if (count!=0)
            {
                System.out.println(count+" Product Deleted Successfully!!");
            }
            else
            {
                System.out.println("Product Not Found!!");
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
        }

    }
}
