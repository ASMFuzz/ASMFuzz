import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_3755 {

    static String arg = ";,Fsa <;?P";

    byte m_byte(String arg) {
        return 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3755().m_byte(arg));
    }
}
