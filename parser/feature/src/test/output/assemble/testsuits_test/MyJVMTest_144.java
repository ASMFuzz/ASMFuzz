import java.util.ResourceBundle;

public class MyJVMTest_144 {

    static ResourceBundle bundle = ResourceBundle.getBundle("Bug6356571");

    void check() {
        String id = bundle.getString("id");
        if (!"6356571".equals(id)) {
            throw new RuntimeException("wrong id: " + id);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_144().check();
    }
}
