public class MyJVMTest_7916 {

    static long val = 0;

    static int distance = 3;

    long testRorLongApi(long val, int distance) {
        return Long.rotateRight(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7916().testRorLongApi(val, distance));
    }
}
