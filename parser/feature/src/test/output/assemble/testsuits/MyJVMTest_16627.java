import java.util.ArrayList;

public class MyJVMTest_16627 {

    static int flags = 0;

    static int PAGE = 0x2;

    boolean isPage(int flags) {
        return (flags & PAGE) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16627().isPage(flags));
    }
}
