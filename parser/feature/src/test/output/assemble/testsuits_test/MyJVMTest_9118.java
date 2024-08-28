public class MyJVMTest_9118 {

    static long val = 8512087339300098390L;

    static int distance = 0;

    long testRolLongApi(long val, int distance) {
        return Long.rotateLeft(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9118().testRolLongApi(val, distance));
    }
}
