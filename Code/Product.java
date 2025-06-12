import java.util.ArrayList;
import java.util.List;

/**
 * Бүтээгдэхүүний мэдээллийг хадгалах класс.
 */
public class Product {
    private String name, category, madeIn, material, color, size;
    private int stock;
    private double price;

    /**
     * Бүтээгдэхүүний шинэ обьектыг үүсгэнэ.
     *
     * @param name бүтээгдэхүүний нэр
     * @param category бүтээгдэхүүний ангилал
     * @param madeIn үйлдвэрлэсэн улс
     * @param material бүтээгдэхүүний материал
     * @param color өнгө
     * @param size хэмжээ
     * @param stock үлдэгдэл тоо ширхэг
     * @param price үнэ
     */
    public Product(String name, String category, String madeIn, String material, String color, String size, int stock, double price) {
        this.name = name;
        this.category = category;
        this.madeIn = madeIn;
        this.material = material;
        this.color = color;
        this.size = size;
        this.stock = stock;
        this.price = price;
    }

    /**
     * Ангилал, дэд ангилалаар бүтээгдэхүүнүүдийг шүүнэ.
     *
     * @param category бүтээгдэхүүний үндсэн ангилал
     * @param subcategory бүтээгдэхүүний дэд ангилал
     * @return шалгуурт нийцсэн бүтээгдэхүүнүүдийн жагсаалт
     */
    public static List<Product> getProductsByCategory(String category, String subcategory) {
        List<Product> products = new ArrayList<>();
        
        if (category.equals("Huvtsas")) {
            products.add(new Product("Tsamts", category + "/" + subcategory, "Mongol", "Noos", "Tsagaan", "M", 15, 45000));
            products.add(new Product("Hurem", category + "/" + subcategory, "Solongos", "Poliestr", "Har", "S", 10, 38000));
            products.add(new Product("Umd", category + "/" + subcategory, "Hytad", "Huvun", "Huh", "L", 20, 25000));
        } else {
            products.add(new Product("Shiree", "Ger ahuin baraa/Tavilga", "Hytad", "Mod", "Bor", "150x75", 5, 120000));
            products.add(new Product("Sandal", "Ger ahuin baraa/Tavilga", "Oros", "Metial", "Saaral", "Standart", 10, 50000));
            products.add(new Product("Toos sorogch", "Ger ahuin baraa/Tsahilgaan baraa", "German", "Huvantsar", "Har", "1.5L", 8, 185000));
        }
        
        return products;
    }

    /**
     * Бүтээгдэхүүний үлдэгдлийг тохируулна.
     *
     * @param qty хасах тоо ширхэг
     */
    public void reduceStock(int qty) {
        if (qty <= stock) stock -= qty;
    }

    /**
     * @return бүтээгдэхүүний нэр
     */
    public String getName() { return name; }

    /**
     * @return бүтээгдэхүүний ангилал
     */
    public String getCategory() { return category; }

    /**
     * @return үйлдвэрлэсэн улс
     */
    public String getMadeIn() { return madeIn; }

    /**
     * @return бүтээгдэхүүний материал
     */
    public String getMaterial() { return material; }

    /**
     * @return бүтээгдэхүүний өнгө
     */
    public String getColor() { return color; }

    /**
     * @return бүтээгдэхүүний хэмжээ
     */
    public String getSize() { return size; }

    /**
     * @return бүтээгдэхүүний үлдэгдэл тоо ширхэг
     */
    public int getStock() { return stock; }

    /**
     * @return бүтээгдэхүүний үнэ
     */
    public double getPrice() { return price; }
}