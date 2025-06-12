import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CartItemTest {
    private Product testProduct;
    private CartItem cartItem;

    @Before
    public void setUp() {
        testProduct = new Product("iPhone 13", "Smartphone", "USA", "Aluminum", "Midnight", "6.1-inch", 10, 3500000.0);
        cartItem = new CartItem(testProduct, 2);
    }

    @Test
    public void testGetTotalWithSingleItem() {
        System.out.println("getTotal() - Нэг тоо ширхэг");
        CartItem singleItem = new CartItem(testProduct, 1);
        double total = singleItem.getTotal();
        System.out.println("Нийт үнэ: " + total);
        assertEquals(3500000.0, total, 0.001);
    }

    @Test
    public void testGetTotalWithZeroQuantity() {
        System.out.println("getTotal() - Тэг тоо ширхэг");
        CartItem zeroItem = new CartItem(testProduct, 0);
        double total = zeroItem.getTotal();
        System.out.println("Нийт үнэ: " + total);
        assertEquals(0.0, total, 0.001);
    }
    
    @Test
    public void testLargeQuantity() {
        System.out.println("Том тоо ширхэг");
        CartItem largeQuantityItem = new CartItem(testProduct, Integer.MAX_VALUE);
        double total = largeQuantityItem.getTotal();
        System.out.println("Quantity: " + Integer.MAX_VALUE);
        System.out.println("Нийт үнэ: " + total);
        assertEquals(3500000.0 * Integer.MAX_VALUE, total, 0.001);
    }

    @Test
    public void testFractionalPriceProduct() {
        System.out.println("Бутархай үнэтэй бүтээгдэхүүн");
        Product cheapProduct = new Product("Pen", "Stationery", "Japan", "Plastic", "Blue", "One", 200, 1250.50);
        CartItem penItem = new CartItem(cheapProduct, 3);
        double total = penItem.getTotal();
        System.out.println("Нэгж үнэ: " + cheapProduct.getPrice());
        System.out.println("Quantity: " + penItem.getQuantity());
        System.out.println("Нийт үнэ: " + total);
        assertEquals(3751.50, total, 0.001);
    }
}
