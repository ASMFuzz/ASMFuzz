import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_12205 {

    static String arg = "4Xte$-3c3S";

    int m_int(String arg) {
        return 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12205().m_int(arg));
    }
}
