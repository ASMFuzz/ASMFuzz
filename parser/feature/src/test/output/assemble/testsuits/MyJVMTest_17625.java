public class MyJVMTest_17625 {

    static long val = -2592049251942177879L;

    static int distance = 3;

    long testRolLongApi(long val, int distance) {
        return Long.rotateLeft(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17625().testRolLongApi(val, distance));
    }
}
