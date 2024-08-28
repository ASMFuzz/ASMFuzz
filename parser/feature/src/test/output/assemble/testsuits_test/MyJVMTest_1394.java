public class MyJVMTest_1394 {

    static long a = 9223372036854775807L;

    long test_shrc1(long a) {
        return a >> 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1394().test_shrc1(a));
    }
}
