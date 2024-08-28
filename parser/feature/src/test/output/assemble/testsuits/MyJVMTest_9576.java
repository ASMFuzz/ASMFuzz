public class MyJVMTest_9576 {

    static long a = 9223372036854775807L;

    boolean test_isGtC(long a) {
        return a > 7L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9576().test_isGtC(a));
    }
}
