import java.io.Reader;

public class MyJVMTest_6124 {

    static String key = "7WLP[Rm?Mj";

    static Object value = 5;

    String put(String key, Object value) {
        throw new RuntimeException();
        return key;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6124().put(key, value);
    }
}
