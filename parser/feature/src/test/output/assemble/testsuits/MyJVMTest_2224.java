public class MyJVMTest_2224 {

    static long a = 0;

    static long IMM = 0xf0f0f0f0f0f0f0f0L;

    long test_orc1(long a) {
        return a | IMM;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2224().test_orc1(a));
    }
}
