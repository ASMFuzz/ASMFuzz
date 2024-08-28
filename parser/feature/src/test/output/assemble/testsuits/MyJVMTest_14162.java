public class MyJVMTest_14162 {

    static int val = 2;

    int testRorOrInt32And(int val) {
        return val & ((val >>> 32) | (val << (32 - 32)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14162().testRorOrInt32And(val));
    }
}
