import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_731 {

    static short arg = -32768;

    String n_short(short arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_731().n_short(arg));
    }
}
