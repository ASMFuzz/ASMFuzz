import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_10028 {

    static String arg = "jvrJXBG&j^";

    long m_long(String arg) {
        return 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10028().m_long(arg));
    }
}
