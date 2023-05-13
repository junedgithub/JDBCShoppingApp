package ShoppingApp;

import java.sql.*;
import java.util.Scanner;

public class UpdateQuantity {
    public static void updateQuantity() {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "";
        System.out.print("Enter Product Name : ");
        String name = sc.next();
        System.out.print("Enter New Quantity : ");
        int qty = sc.nextInt();
        int c_qty = 0;
        int result = 0;
        try {
            query = "select * from cart";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                if (name.equals(rs.getString(1)))
                {
                    if (qty<=(rs.getInt(2)))
                    {
                        c_qty = rs.getInt(2);
                       String query1 = "update cart set qty = ? where name = ?";
                       pstmt = con.prepareStatement(query1);
                       pstmt.setInt(1,(c_qty+qty));
                       pstmt.setString(2,name);
                       pstmt.executeUpdate();
                        System.out.println("Cart Updates Successfully!!");
                    }
                }
            }
            String query2 = "select * from product";
            pstmt = con.prepareStatement(query2);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                if (name.equals(rs.getString(2)))
                {
                    if (qty<=rs.getInt(3))
                    {
                        String query3 = "update product set product_qty = ? where product_name =?";
                        pstmt= con.prepareStatement(query3);
                        pstmt.setInt(1,(rs.getInt(3)-c_qty));
                        pstmt.setString(2,name);
                        pstmt.executeUpdate();
                        System.out.println(" Product Updated Successfully!!");
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

