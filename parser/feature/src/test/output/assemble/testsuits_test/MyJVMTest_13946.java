public class MyJVMTest_13946 {

    static long a = -9223372036854775808L;

    static long IIMM12_1 = 0xfff;

    long test_addc1(long a) {
        return a + IIMM12_1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13946().test_addc1(a));
    }
}
