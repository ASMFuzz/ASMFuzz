public class MyJVMTest_8626 {

    static int val = 0;

    static int distance = 3;

    int testRorIntApi(int val, int distance) {
        return Integer.rotateRight(val, distance);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8626().testRorIntApi(val, distance));
    }
}
