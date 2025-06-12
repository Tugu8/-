/**
 * Системд нэвтрэх хэрэглэгчийн мэдээллийг хадгалах класс.
 * Хэрэглэгчийн үндсэн мэдээлэл болох и-мэйл, нэр, нууц үгийг агуулна.
 */
public class User {
    private String email;
    private String name;
    private String password;

    /**
     * Хэрэглэгчийн обьектыг и-мэйл, нэр, нууц үгээр үүсгэнэ.
     *
     * @param email хэрэглэгчийн и-мэйл хаяг (уникаль утга)
     * @param name хэрэглэгчийн бүтэн нэр
     * @param password хэрэглэгчийн нууц үг (6-аас дээш тэмдэгтээс бүрдсэн)
     * @throws IllegalArgumentException параметрүүд хоосон эсвэл null байвал, 
     *                                  эсвэл нууц үг 6-аас бага тэмдэгтээс бүрдсэн бол
     */
    public User(String email, String name, String password) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("И-мэйл хоосон байж болохгүй");
        }
        
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Нэр хоосон байж болохгүй");
        }
        
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Нууц үг хоосон байж болохгүй");
        }
        
        if (password.length() < 6) {
            throw new IllegalArgumentException("Нууц үг хамгийн багадаа 6 тэмдэгтээс бүрдэх ёстой");
        }

        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPassword() { return password; }
}


