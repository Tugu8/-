import java.util.*;

/**
 * Захиалгын мэдээллийг хадгалах класс.
 */
public class Order {
    private User user;
    private List<CartItem> items;
    private String shippingAddress;
    private String paymentMethod;

    /**
     * Захиалгын шинэ обьектыг үүсгэнэ.
     *
     * @param user захиалга өгөх хэрэглэгч
     * @param items захиалгын бүтээгдэхүүнүүдийн жагсаалт
     * @param shippingAddress хүргэлтийн хаяг
     * @param paymentMethod төлбөрийн арга
     */
    public Order(User user, List<CartItem> items, String shippingAddress, String paymentMethod) {
        this.user = user;
        this.items = items;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
    }

    /**
     * Захиалгын нийт дүнг тооцоолно.
     *
     * @return бүх бүтээгдэхүүний нийт дүн
     */
    public double calculateTotal() {
        return items.stream().mapToDouble(CartItem::getTotal).sum();
    }

    /**
     * Захиалгыг баталгаажуулж, бүтээгдэхүүний үлдэгдлийг шинэчлэнэ.
     * Баталгаажуулалтын мессеж, нийт дүн, төлбөрийн арга, хүргэлтийн хаягийг хэвлэнэ.
     */
    public void confirmOrder() {
        for (CartItem item : items) {
            item.getProduct().reduceStock(item.getQuantity());
        }
        System.out.println("\nZahialga batalgaajlaa!");
        System.out.println("Niit une: ₮" + calculateTotal());
        System.out.println("Tulburiin heregsel: " + paymentMethod);
        System.out.println("Hurgeltiin hayg: " + shippingAddress);
    }
}