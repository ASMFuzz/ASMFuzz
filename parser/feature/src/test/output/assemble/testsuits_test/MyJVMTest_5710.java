import java.util.*;

public class MyJVMTest_5710 {

    static String arg = "N&3)gj*xhN";

    Integer parseFromString(String arg) {
        return Integer.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5710().parseFromString(arg));
    }
}
