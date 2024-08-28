public class MyJVMTest_16188 {

    static int val = 9;

    int testRorOrInt31Bic(int val) {
        return val & (-1 ^ ((val >>> 31) | (val << (32 - 31))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16188().testRorOrInt31Bic(val));
    }
}
