import java.util.concurrent.*;
import java.lang.reflect.*;

public class MyJVMTest_5502 {

    static ThreadLocalRandom rng = null;

    static Field valueField = null;

    static int LITTLE_GARBAGE_COUNT = 1 << 5;

    static MyClass sink = null;

    static String s = "!\"5]W>zn@@";

    static Object value = 8;

    static long valuePointer = -9223372036854775808L;

    ThreadLocalRandom createLittleGarbage(ThreadLocalRandom rng) {
        int count = rng.nextInt(LITTLE_GARBAGE_COUNT);
        for (int index = 0; index < count; index++) {
            sink = new MyClass();
        }
        return rng;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5502().createLittleGarbage(rng);
    }
}
