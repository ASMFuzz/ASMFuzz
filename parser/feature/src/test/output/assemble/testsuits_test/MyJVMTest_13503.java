public class MyJVMTest_13503 {

    static int val = 4;

    int testRorOrInt1(int val) {
        return (val >>> 1) | (val << (32 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13503().testRorOrInt1(val));
    }
}
