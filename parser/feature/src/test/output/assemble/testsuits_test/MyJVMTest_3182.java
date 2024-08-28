import java.util.HashMap;

public class MyJVMTest_3182 {

    static String key = ".Z;q>$b->C";

    static HashMap errors = null;

    boolean specialCaseFound(String key) {
        return ((Boolean) errors.get(key)).booleanValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3182().specialCaseFound(key));
    }
}
