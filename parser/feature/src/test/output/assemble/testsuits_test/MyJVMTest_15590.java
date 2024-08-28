import java.io.Reader;

public class MyJVMTest_15590 {

    static String key = "b(fiQ/e=^|";

    static Object value = 1;

    String put(String key, Object value) {
        throw new RuntimeException();
        return key;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15590().put(key, value);
    }
}
