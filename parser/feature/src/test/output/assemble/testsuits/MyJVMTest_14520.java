import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_14520 {

    static String arg = "Anr!cInN,}";

    Object m_Object(String arg) {
        return new Object();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14520().m_Object(arg));
    }
}
