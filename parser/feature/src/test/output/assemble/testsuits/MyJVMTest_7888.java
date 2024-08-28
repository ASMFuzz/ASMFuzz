public class MyJVMTest_7888 {

    static int val = 7;

    int testRorOrInt32Eor(int val) {
        return val ^ ((val >>> 32) | (val << (32 - 32)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7888().testRorOrInt32Eor(val));
    }
}
