import java.lang.invoke.*;

public class MyJVMTest_17756 {

    static long x = 9223372036854775807L;

    String l2h(long x) {
        return Long.toHexString(x);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17756().l2h(x));
    }
}
