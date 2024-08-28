public class MyJVMTest_11478 {

    static long a = 9223372036854775807L;

    static long IMM = 0xf0f0f0f0f0f0f0f0L;

    long test_orc1(long a) {
        return a | IMM;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11478().test_orc1(a));
    }
}
