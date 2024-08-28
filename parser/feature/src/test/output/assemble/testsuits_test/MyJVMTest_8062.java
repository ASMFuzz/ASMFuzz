public class MyJVMTest_8062 {

    static long a = 7379881190104810314L;

    static long IIMM12_0 = 0x1;

    long test_addc0(long a) {
        return a + IIMM12_0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8062().test_addc0(a));
    }
}
