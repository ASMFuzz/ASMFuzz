import java.security.*;
import javax.crypto.*;

public class MyJVMTest_3048 {

    static Object o1 = 1036657780;

    static Object o2 = 9;

    Object same(Object o1, Object o2) throws Exception {
        if (o1 != o2) {
            throw new Exception("not same object");
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3048().same(o1, o2);
    }
}
