public class MyJVMTest_8027 {

    static long a = -9223372036854775808L;

    static long IMM = 0xf0f0f0f0f0f0f0f0L;

    long test_xorc1(long a) {
        return a ^ IMM;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8027().test_xorc1(a));
    }
}
