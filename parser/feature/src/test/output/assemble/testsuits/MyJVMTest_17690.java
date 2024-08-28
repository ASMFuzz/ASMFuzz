import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_17690 {

    static byte arg = -128;

    String n_byte(byte arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17690().n_byte(arg));
    }
}
