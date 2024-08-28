import java.lang.reflect.*;

public class MyJVMTest_9189 {

    static long v = -9223372036854775808L;

    long bh_sr_long(long v) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9189().bh_sr_long(v));
    }
}
