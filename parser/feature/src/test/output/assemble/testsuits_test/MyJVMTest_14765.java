import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_14765 {

    static int arg = 0;

    String n_int(int arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14765().n_int(arg));
    }
}
