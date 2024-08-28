import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_8892 {

    static boolean value = true;

    boolean assertTrue(boolean value) throws Exception {
        if (!value)
            throw new RuntimeException("assertTrue fails!");
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8892().assertTrue(value);
    }
}
