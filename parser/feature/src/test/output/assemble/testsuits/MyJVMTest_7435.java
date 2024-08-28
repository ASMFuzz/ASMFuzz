public class MyJVMTest_7435 {

    static int val = 8;

    int testRorOrInt32Orn(int val) {
        return val | (-1 ^ ((val >>> 32) | (val << (32 - 32))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7435().testRorOrInt32Orn(val));
    }
}
