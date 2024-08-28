import java.util.*;

public class MyJVMTest_17386 {

    static String arg = "p\\\\FNRYA3_";

    Boolean parseFromString(String arg) {
        return arg == null || "".equals(arg) || "1".equalsIgnoreCase(arg) || "true".equalsIgnoreCase(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17386().parseFromString(arg));
    }
}
