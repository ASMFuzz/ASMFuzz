public class MyJVMTest_17478 {

    static long val = -9223372036854775808L;

    static int distance = 0;

    long testRorLongApi(long val, int distance) {
        return Long.rotateRight(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17478().testRorLongApi(val, distance));
    }
}
