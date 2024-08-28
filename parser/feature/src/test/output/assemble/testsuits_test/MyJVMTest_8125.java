import java.util.ResourceBundle;

public class MyJVMTest_8125 {

    static String key = "#5cI(*@ZVZ";

    static String expected = "U;Jy\"1gX0@";

    static ResourceBundle bundle = null;

    String checkValue(String key, String expected) throws Exception {
        String result = bundle.getString(key);
        if (!result.equals(expected)) {
            throw new RuntimeException("Got wrong value from resource bundle" + " - key: " + key + ", expected: " + expected + ", got: " + result);
        }
        return key;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8125().checkValue(key, expected);
    }
}
