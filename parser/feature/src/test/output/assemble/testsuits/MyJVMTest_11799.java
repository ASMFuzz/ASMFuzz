import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_11799 {

    static String arg = "|`o(RS;<!(";

    short m_short(String arg) {
        return 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11799().m_short(arg));
    }
}
