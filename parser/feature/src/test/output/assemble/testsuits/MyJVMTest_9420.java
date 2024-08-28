public class MyJVMTest_9420 {

    static long a = -9223372036854775808L;

    boolean test_isNeC(long a) {
        return a != 7L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9420().test_isNeC(a));
    }
}
