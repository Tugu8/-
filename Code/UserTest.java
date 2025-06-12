import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest {
    
    @Test
    public void testValidUserCreation() {
        System.out.println("\n=== Хүчинтэй хэрэглэгч үүсгэх тест ===");
        
        String email = "user@gmail.com";
        String name = "Бат";
        String password = "password123";
        
        System.out.println("[ОРУУЛСАН] Email: " + email);
        System.out.println("[ОРУУЛСАН] Нэр: " + name);
        System.out.println("[ОРУУЛСАН] Нууц үг: " + password);
        
        User user = new User(email, name, password);
        
        System.out.println("[ХҮЛЭЭГДЭЖ БУЙ] Email: " + email);
        System.out.println("[БОДИТ] Email: " + user.getEmail());
        assertEquals(email, user.getEmail());
        
        System.out.println("[ХҮЛЭЭГДЭЖ БУЙ] Нэр: " + name);
        System.out.println("[БОДИТ] Нэр: " + user.getName());
        assertEquals(name, user.getName());
        
        System.out.println("[ХҮЛЭЭГДЭЖ БУЙ] Нууц үг: " + password);
        System.out.println("[БОДИТ] Нууц үг: " + user.getPassword());
        assertEquals(password, user.getPassword());
        
        System.out.println(" Хэрэглэгч амжилттай үүслээ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullEmail() {
        System.out.println("\n=== Null email шалгах тест ===");
        System.out.println("[ОРУУЛСАН] Email: null");
        System.out.println("[ОРУУЛСАН] Нэр: Бат");
        System.out.println("[ОРУУЛСАН] Нууц үг: password123");
        System.out.println("[ХҮЛЭЭГДЭЖ БУЙ] IllegalArgumentException алдаа");
        
        new User(null, "Бат", "password123");
        
        System.out.println("✗ Алдаа гарсангүй (алдаа гарч байх ёстой)");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyEmail() {
        System.out.println("\n=== Хоосон email шалгах тест ===");
        System.out.println("[ОРУУЛСАН] Email: \"\"");
        System.out.println("[ХҮЛЭЭГДЭЖ БУЙ] IllegalArgumentException алдаа");
        
        new User("", "Бат", "password123");
        
        System.out.println(" Алдаа гарсангүй (алдаа гарч байх ёстой)");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShortPassword() {
        System.out.println("\n=== Богино нууц үг шалгах тест ===");
        String shortPassword = "pass1";
        System.out.println("[ОРУУЛСАН] Нууц үг: " + shortPassword + " (урт: " + shortPassword.length() + ")");
        System.out.println("[ХҮЛЭЭГДЭЖ БУЙ] IllegalArgumentException алдаа");
        
        new User("user@gmail.com", "Бат", shortPassword);
        
        System.out.println(" Алдаа гарсангүй (алдаа гарч байх ёстой)");
    }

    @Test
    public void testMinimumLengthPassword() {
        System.out.println("\n=== Хамгийн бага урттай нууц үг шалгах тест ===");
        String minPassword = "pass12";
        System.out.println("[ОРУУЛСАН] Нууц үг: " + minPassword + " (урт: " + minPassword.length() + ")");
        
        User user = new User("user@gmail.com", "Бат", minPassword);
        
        System.out.println("[БОДИТ] Нууц үг: " + user.getPassword());
        assertEquals(minPassword, user.getPassword());
        System.out.println(" 6 тэмдэгт нууц үг хүлээн авсан");
    }
}



