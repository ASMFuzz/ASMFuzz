public class MyJVMTest_13068 {

    static int val = -425876559;

    int testRorOrInt32Eon(int val) {
        return val ^ (-1 ^ ((val >>> 32) | (val << (32 - 32))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13068().testRorOrInt32Eon(val));
    }
}
