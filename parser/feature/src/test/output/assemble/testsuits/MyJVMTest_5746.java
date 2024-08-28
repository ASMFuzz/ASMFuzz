public class MyJVMTest_5746 {

    static long a = -9223372036854775808L;

    static long IIMM24_5 = 0x1001000;

    long test_addc5(long a) {
        return a + IIMM24_5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5746().test_addc5(a));
    }
}
