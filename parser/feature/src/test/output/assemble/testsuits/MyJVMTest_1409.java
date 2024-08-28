import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_1409 {

    static boolean value = false;

    boolean assertTrue(boolean value) throws Exception {
        if (!value)
            throw new RuntimeException("assertTrue fails!");
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1409().assertTrue(value);
    }
}
