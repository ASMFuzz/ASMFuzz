public class MyJVMTest_9454 {

    static int val = 7;

    static int distance = 0;

    int testRorIntApi(int val, int distance) {
        return Integer.rotateRight(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9454().testRorIntApi(val, distance));
    }
}
