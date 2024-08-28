import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_2906 {

    static String arg = "%fc3b0W5]T";

    int m_int(String arg) {
        return 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2906().m_int(arg));
    }
}
