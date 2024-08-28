public class MyJVMTest_4920 {

    static long value = -9223372036854775808L;

    long unchecked(long value) {
        return value + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4920().unchecked(value));
    }
}
