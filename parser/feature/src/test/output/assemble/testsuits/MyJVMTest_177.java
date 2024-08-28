public class MyJVMTest_177 {

    static String name = "VZa(BxAK%k";

    static long value = -5552476452495483658L;

    int intValue() {
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            throw new RuntimeException("Overflow/Underflow: " + value);
        }
        return (int) value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_177().intValue());
    }
}
