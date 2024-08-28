import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_17565 {

    static boolean arg = false;

    String n_boolean(boolean arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17565().n_boolean(arg));
    }
}
