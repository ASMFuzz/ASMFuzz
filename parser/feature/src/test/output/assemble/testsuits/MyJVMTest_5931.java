import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_5931 {

    static long arg = -9223372036854775808L;

    String n_long(long arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5931().n_long(arg));
    }
}
