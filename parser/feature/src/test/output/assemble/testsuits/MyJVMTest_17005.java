import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_17005 {

    static String arg = "1xRAtWNN;(";

    char m_char(String arg) {
        return 'x';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17005().m_char(arg));
    }
}
