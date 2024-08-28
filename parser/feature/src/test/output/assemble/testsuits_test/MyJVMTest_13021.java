public class MyJVMTest_13021 {

    static long a = 9223372036854775807L;

    static long IMM = 0xf0f0f0f0f0f0f0f0L;

    static long NO_IMM = 0x123456d5123456d5L;

    long test_orc2(long a) {
        return a | NO_IMM;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13021().test_orc2(a));
    }
}
