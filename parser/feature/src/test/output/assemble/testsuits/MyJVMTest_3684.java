public class MyJVMTest_3684 {

    static long a = 0;

    static long IMM = 0xf0f0f0f0f0f0f0f0L;

    static long NO_IMM = 0x123456d5123456d5L;

    long test_orc2(long a) {
        return a | NO_IMM;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3684().test_orc2(a));
    }
}
