import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_15383 {

    static long arg = 0;

    String n_long(long arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15383().n_long(arg));
    }
}
