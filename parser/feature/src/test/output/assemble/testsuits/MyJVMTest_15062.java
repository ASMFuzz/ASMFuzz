import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_15062 {

    static Object arg = 0;

    String n_Object(Object arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15062().n_Object(arg));
    }
}
