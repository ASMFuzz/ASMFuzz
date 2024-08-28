import java.security.*;
import javax.crypto.*;

public class MyJVMTest_12358 {

    static Object o1 = 1443360448;

    static Object o2 = 0;

    Object same(Object o1, Object o2) throws Exception {
        if (o1 != o2) {
            throw new Exception("not same object");
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12358().same(o1, o2);
    }
}
