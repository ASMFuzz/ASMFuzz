public class MyJVMTest_302 {

    static int val = 429207339;

    static int distance = 9;

    int testRorIntApi(int val, int distance) {
        return Integer.rotateRight(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_302().testRorIntApi(val, distance));
    }
}
