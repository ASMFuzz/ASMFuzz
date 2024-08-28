public class MyJVMTest_6886 {

    static int val = 3;

    static int distance = 3;

    int testRolIntApi(int val, int distance) {
        return Integer.rotateLeft(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6886().testRolIntApi(val, distance));
    }
}
