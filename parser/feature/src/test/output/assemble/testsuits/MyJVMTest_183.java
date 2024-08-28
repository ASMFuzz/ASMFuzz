import java.util.ArrayList;

public class MyJVMTest_183 {

    static int flags = 1268739278;

    static int SWING2D = 0x4;

    boolean isCommon(int flags) {
        return (flags & SWING2D) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_183().isCommon(flags));
    }
}
