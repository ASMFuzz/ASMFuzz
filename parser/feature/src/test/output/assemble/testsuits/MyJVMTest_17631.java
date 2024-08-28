public class MyJVMTest_17631 {

    static long a = 0;

    static long IIMM12_0 = 0x1;

    long test_addc0(long a) {
        return a + IIMM12_0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17631().test_addc0(a));
    }
}
