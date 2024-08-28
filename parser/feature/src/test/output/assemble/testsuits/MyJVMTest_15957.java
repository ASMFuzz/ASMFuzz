import sun.management.*;

public class MyJVMTest_15957 {

    static long value = 9223372036854775807L;

    static String label = "AW:?=U(CDP";

    long checkPositive(long value, String label) {
        if (value < 0)
            throw new RuntimeException(label + " had a negative value of " + value);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15957().checkPositive(value, label);
    }
}
