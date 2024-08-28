import java.util.ArrayList;

public class MyJVMTest_13141 {

    static int flags = 0;

    static int SWING2D = 0x4;

    static int NATIVE2D = 0x8;

    boolean is2D(int flags) {
        return (flags & SWING2D | NATIVE2D) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13141().is2D(flags));
    }
}
