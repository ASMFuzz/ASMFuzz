public class MyJVMTest_14335 {

    static long a = 9223372036854775807L;

    boolean test_isGeC(long a) {
        return a >= 7L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14335().test_isGeC(a));
    }
}
