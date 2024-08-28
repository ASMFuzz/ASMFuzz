import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_13094 {

    static String arg = "Wz,BY+7-[7";

    byte m_byte(String arg) {
        return 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13094().m_byte(arg));
    }
}
