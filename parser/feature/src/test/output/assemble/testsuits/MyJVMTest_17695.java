import java.util.ResourceBundle;

public class MyJVMTest_17695 {

    static String key = "qJqqx9i{:S";

    static String expected = "l]EYuUg5B#";

    static ResourceBundle bundle = null;

    String checkValue(String key, String expected) throws Exception {
        String result = bundle.getString(key);
        if (!result.equals(expected)) {
            throw new RuntimeException("Got wrong value from resource bundle" + " - key: " + key + ", expected: " + expected + ", got: " + result);
        }
        return key;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17695().checkValue(key, expected);
    }
}
