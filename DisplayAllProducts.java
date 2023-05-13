package ShoppingApp;

import java.sql.*;

public class DisplayAllProducts {
    public static void displayAllProducts() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select * from product";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("PRODUCT_ID\t\tPRODUCT_NAME\t\tPRODUCT_QTY\t\tPRODUCT_PRICE");
            System.out.println("==================================================================");
            while (rs.next())
            {
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                String product_qty = rs.getString(3);
                double product_price = rs.getDouble(4);
                System.out.println(product_id+"\t\t"+product_name+"\t\t"+product_qty+"\t\t"+product_price);

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
