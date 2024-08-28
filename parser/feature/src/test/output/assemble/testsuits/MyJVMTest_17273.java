public class MyJVMTest_17273 {

    static long a = 9223372036854775807L;

    static long b = 6034670194470147416L;

    long test_rem(long a, long b) {
        return a % b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17273().test_rem(a, b));
    }
}
