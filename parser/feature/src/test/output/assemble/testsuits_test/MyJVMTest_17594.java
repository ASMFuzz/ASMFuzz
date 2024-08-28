public class MyJVMTest_17594 {

    static long a = 0;

    static long IMM = 0xf0f0f0f0f0f0f0f0L;

    long test_xorc1(long a) {
        return a ^ IMM;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17594().test_xorc1(a));
    }
}
