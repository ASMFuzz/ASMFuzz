import java.util.ArrayList;

public class MyJVMTest_8660 {

    static int flags = 3;

    static int SWING2D = 0x4;

    boolean isCommon(int flags) {
        return (flags & SWING2D) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8660().isCommon(flags));
    }
}
