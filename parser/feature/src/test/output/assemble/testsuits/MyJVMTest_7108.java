import java.util.ArrayList;

public class MyJVMTest_7108 {

    static int flags = 5;

    static int PAGE = 0x2;

    boolean isPage(int flags) {
        return (flags & PAGE) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7108().isPage(flags));
    }
}
