import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class ProductTest {
  
    private void printTestHeader(String testName) {
        System.out.println("\n=== " + testName + " ===");
    }
    
    private void printTestResult(boolean passed, String message) {
        System.out.println((passed ? " Амжилттай: " : " Алдаатай: ") + message);
    }
    
    @Test
    public void testProductCreation() {
        printTestHeader("Бүтээгдэхүүний үүсгэлтийн тест");
        
        String name = "Цамц";
        String category = "Хувцас";
        String madeIn = "Монгол";
        String material = "Ноос";
        String color = "Цагаан";
        String size = "M";
        int stock = 15;
        double price = 45000;
        
        System.out.println("Туршилтын өгөгдөл:");
        System.out.printf(" Нэр: %s\n Ангилал: %s\n Үйлдвэрлэсэн улс: %s\n", name, category, madeIn);
        System.out.printf(" Материал: %s\n Өнгө: %s\n Хэмжээ: %s\n", material, color, size);
        System.out.printf("Тоо ширхэг: %d\n Үнэ: %,.2f₮\n", stock, price);
        
        Product p = new Product(name, category, madeIn, material, color, size, stock, price);
        
        try {
            assertEquals(name, p.getName());
            printTestResult(true, "Нэр");
            
            assertEquals(category, p.getCategory());
            printTestResult(true, "Ангилал");
            
            assertEquals(madeIn, p.getMadeIn());
            printTestResult(true, "Үйлдвэрлэсэн улс");
            
            assertEquals(material, p.getMaterial());
            printTestResult(true, "Материал");
            
            assertEquals(color, p.getColor());
            printTestResult(true, "Өнгө");
            
            assertEquals(size, p.getSize());
            printTestResult(true, "Хэмжээ");
            
            assertEquals(stock, p.getStock());
            printTestResult(true, "Тоо ширхэг");
            
            assertEquals(price, p.getPrice(), 0.001);
            printTestResult(true, "Үнэ");
            
            System.out.println("\n Бүх тест амжилттай");
        } catch (AssertionError e) {
            printTestResult(false, e.getMessage());
            throw e;
        }
    }
    
    @Test
    public void testReduceStockSuccess() {
        printTestHeader("Барааны үлдэгдэл амжилттай хасах тест");
        
        Product p = new Product("Цамц", "Хувцас", "Монгол", "Ноос", "Цагаан", "M", 15, 45000);
        
        System.out.println("Анхны үлдэгдэл: " + p.getStock());
        System.out.println("Багасгах тоо хэмжээ: 5");
        
        p.reduceStock(5);
        int newStock = p.getStock();
        System.out.println("Өөрчлөгдсөн үлдэгдэл: " + newStock);
        
        try {
            assertEquals(10, newStock);
            printTestResult(true, "Тоо хэмжээ зөв багассан");
            System.out.println("\n Тест амжилттай");
        } catch (AssertionError e) {
            printTestResult(false, "Тоо хэмжээ буруу: " + e.getMessage());
            throw e;
        }
    }
    
    @Test
    public void testReduceStockNotEnough() {
        printTestHeader("Барааны үлдэгдэл хүрэлцэхгүй тохиолдолд хасах тест");
        
        Product p = new Product("Цамц", "Хувцас", "Монгол", "Ноос", "Цагаан", "M", 15, 45000);
        
        System.out.println("Анхны үлдэгдэл: " + p.getStock());
        System.out.println("Багасгах тоо хэмжээ: 20 ");
        
        p.reduceStock(20);
        int newStock = p.getStock();
        System.out.println("Өөрчлөгдсөн үлдэгдэл: " + newStock);
        
        try {
            assertEquals(15, newStock);
            printTestResult(true, "Тоо хэмжээ өөрчлөгдөөгүй");
            System.out.println("\n Тест амжилттай");
        } catch (AssertionError e) {
            printTestResult(false, "Тоо хэмжээ буруу: " + e.getMessage());
            throw e;
        }
    }    
    
    @Test
    public void testProductToString() {
        printTestHeader("Бүтээгдэхүүний мэдээллийг хэвлэх тест");
        
        Product p = new Product("Цамц", "Хувцас", "Монгол", "Ноос", "Цагаан", "M", 15, 45000);
        
        String expected = "Бүтээгдэхүүн: Цамц, Ангилал: Хувцас, Үнэ: 45,000.00₮";
        String actual = String.format("Бүтээгдэхүүн: %s, Ангилал: %s, Үнэ: %,.2f₮", 
                                    p.getName(), p.getCategory(), p.getPrice());
        
        System.out.println("Хүлээгдэж буй үр дүн: " + expected);
        System.out.println("Бодит үр дүн: " + actual);
        
        try {
            assertEquals(expected, actual);
            printTestResult(true, "Мэдээлэл зөв хэвлэгдсэн");
            System.out.println("\n Тест амжилттай");
        } catch (AssertionError e) {
            printTestResult(false, e.getMessage());
            throw e;
        }
    }
}