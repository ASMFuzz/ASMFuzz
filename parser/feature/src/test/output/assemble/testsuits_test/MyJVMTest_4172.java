import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_4172 {

    static String arg = "u8drkiM[yv";

    Integer m_Integer(String arg) {
        return 23;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4172().m_Integer(arg));
    }
}
