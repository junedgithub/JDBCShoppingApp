package ShoppingApp;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        boolean status = true;
        Scanner sc = new Scanner(System.in);
        while(status)
        {
            System.out.println("1.Display all Products");
            System.out.println("2.Add to cart");
            System.out.println("3.Display cart items");
            System.out.println("4.Remove items from cart");
            System.out.println("5.Update qty from cart");
            System.out.println("6.Exit");
            int ch = sc.nextInt();
            switch (ch)
            {
                case 1: DisplayAllProducts.displayAllProducts();
                    break;
                case 2:
                    System.out.println("Enter Product Name");
                    String product_name = sc.next();
                    System.out.println("Enter Quantity");
                    int qty = sc.nextInt();
                    AddToCart.addToCart(product_name,qty);
                    break;
                case 3:DisplayCartProduct.displayProduct();
                    break;
                case 4:
                    System.out.println("Enter Product to be deleted");
                    String name = sc.next();
                    RemoveItemFromCart.removeItem(name);
                    break;
                case 5: UpdateQuantity.updateQuantity();
                    break;
                case 6: status = false;
            }
        }
    }
}
