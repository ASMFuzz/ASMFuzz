import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_4743 {

    static String arg = "E,Q38 0;^R";

    double m_double(String arg) {
        return 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4743().m_double(arg));
    }
}
