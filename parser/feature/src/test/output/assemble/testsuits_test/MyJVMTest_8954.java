public class MyJVMTest_8954 {

    static long val = 0;

    static int distance = 0;

    long testRorLongApi(long val, int distance) {
        return Long.rotateRight(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8954().testRorLongApi(val, distance));
    }
}
