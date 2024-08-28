public class MyJVMTest_8818 {

    static int val = 0;

    int testRorOrInt32Orn(int val) {
        return val | (-1 ^ ((val >>> 32) | (val << (32 - 32))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8818().testRorOrInt32Orn(val));
    }
}
