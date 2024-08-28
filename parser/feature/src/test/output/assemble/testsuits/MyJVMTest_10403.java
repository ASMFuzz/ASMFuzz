public class MyJVMTest_10403 {

    static long a = -9223372036854775808L;

    static long IIMM24_3 = 0x1000;

    long test_addc3(long a) {
        return a + IIMM24_3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10403().test_addc3(a));
    }
}
