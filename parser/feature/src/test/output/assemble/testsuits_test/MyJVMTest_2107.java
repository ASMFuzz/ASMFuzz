import java.util.Set;
import java.util.HashSet;

public class MyJVMTest_2107 {

    static String key = " 5l4/Xam^,";

    static Set<String> keys = new HashSet<String>();

    String callback(String key) {
        if (!keys.contains(key)) {
            keys.add(key);
        }
        return key;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2107().callback(key);
    }
}
