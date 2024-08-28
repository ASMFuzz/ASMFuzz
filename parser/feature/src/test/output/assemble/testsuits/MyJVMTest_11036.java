import java.io.*;

public class MyJVMTest_11036 {

    static long n = -9223372036854775808L;

    long skip(long n) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11036().skip(n));
    }
}
