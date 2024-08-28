import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_15960 {

    static Object a = -1487013330;

    static Object b = 6;

    Object assertEquals(Object a, Object b) throws Exception {
        if (!a.equals(b))
            throw new RuntimeException("assertEquals fails!");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15960().assertEquals(a, b);
    }
}
