import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_11301 {

    static String arg = "i1(8TEVOz<";

    String m_String(String arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11301().m_String(arg));
    }
}
