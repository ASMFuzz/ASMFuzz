import java.util.*;

public class MyJVMTest_12384 {

    static long j = 9223372036854775807L;

    B copy(long j) {
        throw new AssertionError("Should not get here.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12384().copy(j));
    }
}
