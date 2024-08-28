public class MyJVMTest_8776 {

    static int val = 922420379;

    int testRorOrInt32And(int val) {
        return val & ((val >>> 32) | (val << (32 - 32)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8776().testRorOrInt32And(val));
    }
}
