import sun.management.*;

public class MyJVMTest_6469 {

    static long value = 4586877813783496473L;

    static String label = "[~/; 4@zSa";

    long checkPositive(long value, String label) {
        if (value < 0)
            throw new RuntimeException(label + " had a negative value of " + value);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6469().checkPositive(value, label);
    }
}
