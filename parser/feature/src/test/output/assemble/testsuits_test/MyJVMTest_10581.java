public class MyJVMTest_10581 {

    static long a = -2826517244959049220L;

    static long IMM = 0xf0f0f0f0f0f0f0f0L;

    static long NO_IMM = 0x123456d5123456d5L;

    long test_andc2(long a) {
        return a & NO_IMM;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10581().test_andc2(a));
    }
}
