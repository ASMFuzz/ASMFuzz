public class MyJVMTest_8750 {

    static int val = 0;

    int testRorOrInt32Eor(int val) {
        return val ^ ((val >>> 32) | (val << (32 - 32)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8750().testRorOrInt32Eor(val));
    }
}
