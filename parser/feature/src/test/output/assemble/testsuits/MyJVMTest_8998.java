import java.util.concurrent.*;
import java.lang.reflect.*;

public class MyJVMTest_8998 {

    static ThreadLocalRandom rng = null;

    static Field valueField = null;

    static int LITTLE_GARBAGE_COUNT = 1 << 5;

    static MyClass sink = null;

    static String s = "\"R^_!%: D#";

    static Object value = 0;

    static long valuePointer = -9223372036854775808L;

    ThreadLocalRandom createLittleGarbage(ThreadLocalRandom rng) {
        int count = rng.nextInt(LITTLE_GARBAGE_COUNT);
        for (int index = 0; index < count; index++) {
            sink = new MyClass();
        }
        return rng;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8998().createLittleGarbage(rng);
    }
}
