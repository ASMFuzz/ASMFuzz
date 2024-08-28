import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_13533 {

    static String arg = "[L4'Be.4mQ";

    Integer m_Integer(String arg) {
        return 23;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13533().m_Integer(arg));
    }
}
