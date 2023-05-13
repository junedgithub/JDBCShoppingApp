package ShoppingApp;

import java.sql.*;
import java.util.Scanner;

public class AddToCart {
    public static void addToCart(String name, int qty )
    {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String query = "select product_name, product_qty, product_price from product where product_name = '"+name+"'";


        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next())
            {
                if (qty<=rs.getInt(2))
                {
                  String  queryForCart = "insert into cart values('"+rs.getString(1)+"',"+qty+","+rs.getDouble(3)+")";
                  int  count = stmt.executeUpdate(queryForCart);
                    System.out.println(count+" Added Successfully");
                }
            }else {
                System.out.println("Product Not available");
            }
            String query1 = "select * from product";
            pstmt = con.prepareStatement(query1);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                if (name.equals(rs.getString(2)))
                {
                    if (qty<=rs.getInt(3))
                    {
                        String query2 = "update product set product_qty = ? where product_name = ?";
                        pstmt= con.prepareStatement(query2);
                        pstmt.setInt(1,(rs.getInt(3)-qty));
                        pstmt.setString(2,name);
                        pstmt.executeUpdate();
                        System.out.println("Updated successfully!!");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
