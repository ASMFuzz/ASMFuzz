import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_6472 {

    static Object a = -1107873406;

    static Object b = 3;

    Object assertEquals(Object a, Object b) throws Exception {
        if (!a.equals(b))
            throw new RuntimeException("assertEquals fails!");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6472().assertEquals(a, b);
    }
}
