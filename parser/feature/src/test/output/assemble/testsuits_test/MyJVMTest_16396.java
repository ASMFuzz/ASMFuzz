public class MyJVMTest_16396 {

    static int val = -693779184;

    static int distance = 0;

    int testRolIntApi(int val, int distance) {
        return Integer.rotateLeft(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16396().testRolIntApi(val, distance));
    }
}
