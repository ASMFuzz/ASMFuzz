public class MyJVMTest_8800 {

    static int val = 1459033101;

    int testRorOrInt1And(int val) {
        return val & ((val >>> 1) | (val << (32 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8800().testRorOrInt1And(val));
    }
}
