import java.util.*;

public class MyJVMTest_15150 {

    static String arg = "P<$1'FF^mR";

    Integer parseFromString(String arg) {
        return Integer.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15150().parseFromString(arg));
    }
}
