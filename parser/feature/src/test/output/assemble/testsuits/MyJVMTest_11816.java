import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_11816 {

    static Integer arg = 9;

    String n_Integer(Integer arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11816().n_Integer(arg));
    }
}
