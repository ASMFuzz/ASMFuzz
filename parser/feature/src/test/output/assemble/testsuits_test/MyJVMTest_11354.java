import java.util.Set;
import java.util.HashSet;

public class MyJVMTest_11354 {

    static String key = "N\"3W&Zn?OA";

    static Set<String> keys = new HashSet<String>();

    String callback(String key) {
        if (!keys.contains(key)) {
            keys.add(key);
        }
        return key;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11354().callback(key);
    }
}
