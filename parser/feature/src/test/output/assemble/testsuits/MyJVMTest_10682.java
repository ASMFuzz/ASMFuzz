public class MyJVMTest_10682 {

    static long a = -9223372036854775808L;

    static long IIMM12_2 = 0x1001;

    long test_addc2(long a) {
        return a + IIMM12_2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10682().test_addc2(a));
    }
}
