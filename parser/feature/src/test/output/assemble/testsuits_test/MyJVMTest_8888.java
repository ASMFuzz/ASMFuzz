public class MyJVMTest_8888 {

    static int val = 4;

    int testRorOrInt16Orn(int val) {
        return val | (-1 ^ ((val >>> 16) | (val << (32 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8888().testRorOrInt16Orn(val));
    }
}
