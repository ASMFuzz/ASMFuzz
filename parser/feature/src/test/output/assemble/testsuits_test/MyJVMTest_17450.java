public class MyJVMTest_17450 {

    static int val = 1;

    int testRorOrInt32Eor(int val) {
        return val ^ ((val >>> 32) | (val << (32 - 32)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17450().testRorOrInt32Eor(val));
    }
}
