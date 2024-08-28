import java.util.ArrayList;

public class MyJVMTest_275 {

    static int flags = 8;

    static int NATIVE2D = 0x8;

    boolean isNative(int flags) {
        return (flags & NATIVE2D) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_275().isNative(flags));
    }
}
