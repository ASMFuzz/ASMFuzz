public class MyJVMTest_8726 {

    static int val = 8;

    int testRorOrInt1(int val) {
        return (val >>> 1) | (val << (32 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8726().testRorOrInt1(val));
    }
}
