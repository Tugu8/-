import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class OrderTest {

    private User user;
    private Product product1;
    private Product product2;
    private CartItem item1;
    private CartItem item2;
    private Order order;

    @Before
    public void setUp() {
        user = new User("testuser", "password123", "test@example.com"); // User ийн утга өгсөн
        product1 = new Product("Гар утас", "Электрон", "Солонгос", "Металл", "Хар", "M", 10, 500000);
        product2 = new Product("Чихэвч", "Аудио", "Хятад", "Хуванцар", "Цагаан", "S", 20, 50000);
        item1 = new CartItem(product1, 1); 
        item2 = new CartItem(product2, 2); 
        List<CartItem> items = Arrays.asList(item1, item2);
        order = new Order(user, items, "Улаанбаатар, СБД", "Картаар");
    }

    @Test
    public void testCalculateTotal() {
        double expected = 500000 + (2 * 50000); // 600000
        double actual = order.calculateTotal();
        
        System.out.println("=== Нийт үнийн тест ===");
        System.out.println("Хүлээгдэж буй нийт үнэ: " + expected);
        System.out.println("Бодитоор тооцсон нийт үнэ: " + actual);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testConfirmOrderReducesStock() {
        int initialStock1 = product1.getStock();
        int initialStock2 = product2.getStock();

        System.out.println("=== Захиалга баталгаажуулалтын тест ===");
        System.out.println("Эхний бүтээгдэхүүний үлдэгдэл: " + initialStock1);
        System.out.println("Хоёр дахь бүтээгдэхүүний үлдэгдэл: " + initialStock2);

        order.confirmOrder();

        int newStock1 = product1.getStock();
        int newStock2 = product2.getStock();

        System.out.println("Захиалгын дараах үлдэгдэл (гар утас): " + newStock1);
        System.out.println("Захиалгын дараах үлдэгдэл (чихэвч): " + newStock2);

        assertEquals(initialStock1 - item1.getQuantity(), newStock1);
        assertEquals(initialStock2 - item2.getQuantity(), newStock2);
    }
}
