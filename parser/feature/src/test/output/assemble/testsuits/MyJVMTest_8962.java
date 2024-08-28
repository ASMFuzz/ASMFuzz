public class MyJVMTest_8962 {

    static int val = 4;

    int testRorOrInt32Or(int val) {
        return val | ((val >>> 32) | (val << (32 - 32)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8962().testRorOrInt32Or(val));
    }
}
