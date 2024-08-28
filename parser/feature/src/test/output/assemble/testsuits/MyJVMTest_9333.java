import java.util.ArrayList;

public class MyJVMTest_9333 {

    static int flags = 7;

    static int SWING2D = 0x4;

    boolean isCommon(int flags) {
        return (flags & SWING2D) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9333().isCommon(flags));
    }
}
