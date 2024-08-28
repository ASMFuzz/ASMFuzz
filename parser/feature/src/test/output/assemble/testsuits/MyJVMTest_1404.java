import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_1404 {

    static double arg = Double.MIN_VALUE;

    String n_double(double arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1404().n_double(arg));
    }
}
