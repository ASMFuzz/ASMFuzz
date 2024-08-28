import java.lang.invoke.*;

public class MyJVMTest_8183 {

    static long x = -9223372036854775808L;

    String l2h(long x) {
        return Long.toHexString(x);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8183().l2h(x));
    }
}
