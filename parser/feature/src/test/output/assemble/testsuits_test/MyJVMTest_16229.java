public class MyJVMTest_16229 {

    static long a = 9223372036854775807L;

    static long IMM = 0xf0f0f0f0f0f0f0f0L;

    long test_andc1(long a) {
        return a & IMM;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16229().test_andc1(a));
    }
}
