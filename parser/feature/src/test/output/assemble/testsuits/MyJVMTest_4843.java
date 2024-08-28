public class MyJVMTest_4843 {

    static int val = 5;

    int testRorOrInt1Bic(int val) {
        return val & (-1 ^ ((val >>> 1) | (val << (32 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4843().testRorOrInt1Bic(val));
    }
}
