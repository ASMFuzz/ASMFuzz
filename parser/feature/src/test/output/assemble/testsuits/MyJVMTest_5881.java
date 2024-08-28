public class MyJVMTest_5881 {

    static long value = -9223372036854775808L;

    long unchecked(long value) {
        return -value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5881().unchecked(value));
    }
}
