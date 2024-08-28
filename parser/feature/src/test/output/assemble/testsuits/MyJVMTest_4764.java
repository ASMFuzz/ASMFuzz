public class MyJVMTest_4764 {

    static int val = 0;

    int testRorOrInt32And(int val) {
        return val & ((val >>> 32) | (val << (32 - 32)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4764().testRorOrInt32And(val));
    }
}
