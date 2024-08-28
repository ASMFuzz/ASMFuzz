public class MyJVMTest_6732 {

    static long a = 0;

    static long IMM = 0xf0f0f0f0f0f0f0f0L;

    long test_andc1(long a) {
        return a & IMM;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6732().test_andc1(a));
    }
}
