public class MyJVMTest_8918 {

    static int val = 3;

    int testRorOrInt1Orn(int val) {
        return val | (-1 ^ ((val >>> 1) | (val << (32 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8918().testRorOrInt1Orn(val));
    }
}
