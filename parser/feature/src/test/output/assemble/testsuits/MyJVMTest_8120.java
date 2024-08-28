import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_8120 {

    static byte arg = -105;

    String n_byte(byte arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8120().n_byte(arg));
    }
}
