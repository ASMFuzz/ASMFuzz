import java.util.*;

public class MyJVMTest_7826 {

    static String arg = "D.qZ8#)=pz";

    Boolean parseFromString(String arg) {
        return arg == null || "".equals(arg) || "1".equalsIgnoreCase(arg) || "true".equalsIgnoreCase(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7826().parseFromString(arg));
    }
}
