import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_5626 {

    static Object arg = 5;

    String n_Object(Object arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5626().n_Object(arg));
    }
}
