import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_10412 {

    static String arg = ">7A'huefP9";

    float m_float(String arg) {
        return 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10412().m_float(arg));
    }
}
