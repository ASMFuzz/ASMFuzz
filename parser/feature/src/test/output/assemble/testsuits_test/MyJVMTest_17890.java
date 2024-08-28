public class MyJVMTest_17890 {

    static long a = 6458739302518332488L;

    static long IIMM24_4 = 0xfff000;

    long test_addc4(long a) {
        return a + IIMM24_4;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17890().test_addc4(a));
    }
}
