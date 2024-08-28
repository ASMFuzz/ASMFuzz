import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_8768 {

    static Object a = 4;

    static Object b = 4;

    Object assertEquals(Object a, Object b) throws Exception {
        if (!a.equals(b))
            throw new RuntimeException("assertEquals fails!");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8768().assertEquals(a, b);
    }
}
