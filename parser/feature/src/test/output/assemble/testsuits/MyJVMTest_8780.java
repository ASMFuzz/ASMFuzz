public class MyJVMTest_8780 {

    static int val = 1330340333;

    int testRorOrInt1Bic(int val) {
        return val & (-1 ^ ((val >>> 1) | (val << (32 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8780().testRorOrInt1Bic(val));
    }
}
