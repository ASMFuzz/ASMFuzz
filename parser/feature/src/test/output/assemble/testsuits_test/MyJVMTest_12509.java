public class MyJVMTest_12509 {

    static int val = 1;

    int testRorOrInt32Bic(int val) {
        return val & (-1 ^ ((val >>> 32) | (val << (32 - 32))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12509().testRorOrInt32Bic(val));
    }
}
