public class MyJVMTest_17831 {

    static long a = 9223372036854775807L;

    long test_mulc4(long a) {
        return a * 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17831().test_mulc4(a));
    }
}
