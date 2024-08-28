public class MyJVMTest_6692 {

    static int val = -686126954;

    int testRorOrInt31Bic(int val) {
        return val & (-1 ^ ((val >>> 31) | (val << (32 - 31))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6692().testRorOrInt31Bic(val));
    }
}
