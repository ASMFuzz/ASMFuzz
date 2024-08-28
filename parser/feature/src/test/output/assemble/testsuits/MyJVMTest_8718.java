public class MyJVMTest_8718 {

    static int val = 8;

    static int distance = 5;

    int testRolIntApi(int val, int distance) {
        return Integer.rotateLeft(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8718().testRolIntApi(val, distance));
    }
}
