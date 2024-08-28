public class MyJVMTest_9327 {

    static String name = "Y:H;_g_hdp";

    static long value = -9223372036854775808L;

    int intValue() {
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            throw new RuntimeException("Overflow/Underflow: " + value);
        }
        return (int) value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9327().intValue());
    }
}
