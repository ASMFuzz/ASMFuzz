public class MyJVMTest_17142 {

    static int val = 0;

    int testRorOrInt31Eon(int val) {
        return val ^ (-1 ^ ((val >>> 31) | (val << (32 - 31))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17142().testRorOrInt31Eon(val));
    }
}
