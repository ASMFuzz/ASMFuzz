import java.util.ArrayList;

public class MyJVMTest_9056 {

    static int flags = 0;

    static int NATIVE2D = 0x8;

    boolean isNative(int flags) {
        return (flags & NATIVE2D) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9056().isNative(flags));
    }
}
