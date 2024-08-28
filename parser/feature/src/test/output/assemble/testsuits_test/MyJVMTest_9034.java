import java.util.ArrayList;

public class MyJVMTest_9034 {

    static int flags = 349741003;

    static int PAGE = 0x2;

    boolean isPage(int flags) {
        return (flags & PAGE) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9034().isPage(flags));
    }
}
