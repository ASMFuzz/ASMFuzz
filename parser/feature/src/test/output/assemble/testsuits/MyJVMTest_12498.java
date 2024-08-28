import java.util.HashMap;

public class MyJVMTest_12498 {

    static String key = "k$x8uIObG/";

    static HashMap errors = null;

    boolean specialCaseFound(String key) {
        return ((Boolean) errors.get(key)).booleanValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12498().specialCaseFound(key));
    }
}
