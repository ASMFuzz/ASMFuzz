public class MyJVMTest_40 {

    static long a = 9223372036854775807L;

    long test_mulc1(long a) {
        return a * 8;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_40().test_mulc1(a));
    }
}
