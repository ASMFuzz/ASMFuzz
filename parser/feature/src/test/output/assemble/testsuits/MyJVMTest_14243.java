public class MyJVMTest_14243 {

    static int val = 8;

    int testRorOrInt1Bic(int val) {
        return val & (-1 ^ ((val >>> 1) | (val << (32 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14243().testRorOrInt1Bic(val));
    }
}
