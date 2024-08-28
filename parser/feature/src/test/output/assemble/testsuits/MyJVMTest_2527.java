import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_2527 {

    static String arg = "9:`WL;G^1P";

    short m_short(String arg) {
        return 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2527().m_short(arg));
    }
}
