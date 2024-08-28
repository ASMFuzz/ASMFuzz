public class MyJVMTest_10381 {

    static int val = 0;

    int testRorOrInt31Orn(int val) {
        return val | (-1 ^ ((val >>> 31) | (val << (32 - 31))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10381().testRorOrInt31Orn(val));
    }
}
