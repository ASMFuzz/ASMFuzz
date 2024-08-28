import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_14141 {

    static String arg = "-MCXH_zf+D";

    double m_double(String arg) {
        return 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14141().m_double(arg));
    }
}
