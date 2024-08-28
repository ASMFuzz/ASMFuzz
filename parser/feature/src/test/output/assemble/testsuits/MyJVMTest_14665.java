public class MyJVMTest_14665 {

    static long a = 9223372036854775807L;

    boolean test_isLtC(long a) {
        return a < 7L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14665().test_isLtC(a));
    }
}
