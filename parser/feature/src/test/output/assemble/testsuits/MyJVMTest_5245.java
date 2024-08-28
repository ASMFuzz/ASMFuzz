public class MyJVMTest_5245 {

    static long a = 9223372036854775807L;

    boolean test_isLtC(long a) {
        return a < 7L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5245().test_isLtC(a));
    }
}
