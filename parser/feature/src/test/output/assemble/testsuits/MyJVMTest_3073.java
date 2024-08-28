import java.util.*;

public class MyJVMTest_3073 {

    static long j = -9223372036854775808L;

    B copy(long j) {
        throw new AssertionError("Should not get here.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3073().copy(j));
    }
}
