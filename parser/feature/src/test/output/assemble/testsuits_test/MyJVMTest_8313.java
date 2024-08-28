public class MyJVMTest_8313 {

    static long a = 9223372036854775807L;

    static long IIMM24_4 = 0xfff000;

    long test_addc4(long a) {
        return a + IIMM24_4;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8313().test_addc4(a));
    }
}
