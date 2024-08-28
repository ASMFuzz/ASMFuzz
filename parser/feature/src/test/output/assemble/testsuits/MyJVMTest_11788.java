public class MyJVMTest_11788 {

    static long a = 9223372036854775807L;

    long test_mulc2(long a) {
        return a * 9;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11788().test_mulc2(a));
    }
}
