import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_7469 {

    static String arg = "^wzlHn#h|1";

    char m_char(String arg) {
        return 'x';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7469().m_char(arg));
    }
}
