public class MyJVMTest_9011 {

    static int val = 6;

    int testRorOrInt31Bic(int val) {
        return val & (-1 ^ ((val >>> 31) | (val << (32 - 31))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9011().testRorOrInt31Bic(val));
    }
}
