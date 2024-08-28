public class MyJVMTest_6354 {

    static long a = 4913948701403691271L;

    static long b = 9223372036854775807L;

    boolean test_isGe(long a, long b) {
        return a >= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6354().test_isGe(a, b));
    }
}
