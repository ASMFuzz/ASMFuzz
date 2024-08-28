public class MyJVMTest_16632 {

    static long a = 9223372036854775807L;

    boolean test_isLeC(long a) {
        return a <= 7L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16632().test_isLeC(a));
    }
}
