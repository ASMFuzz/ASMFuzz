public class MyJVMTest_419 {

    static long a = 9223372036854775807L;

    boolean test_isGtC(long a) {
        return a > 7L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_419().test_isGtC(a));
    }
}
