import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_10073 {

    static float arg = 0f;

    String n_float(float arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10073().n_float(arg));
    }
}
