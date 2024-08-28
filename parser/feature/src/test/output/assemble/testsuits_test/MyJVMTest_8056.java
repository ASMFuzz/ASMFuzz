public class MyJVMTest_8056 {

    static long val = 9223372036854775807L;

    static int distance = 3;

    long testRolLongApi(long val, int distance) {
        return Long.rotateLeft(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8056().testRolLongApi(val, distance));
    }
}
