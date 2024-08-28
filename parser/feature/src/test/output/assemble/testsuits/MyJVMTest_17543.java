public class MyJVMTest_17543 {

    static int val = 1417903973;

    int testRorOrInt16Bic(int val) {
        return val & (-1 ^ ((val >>> 16) | (val << (32 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17543().testRorOrInt16Bic(val));
    }
}
