public class MyJVMTest_15414 {

    static int val = -2028542676;

    int testRorOrInt1Orn(int val) {
        return val | (-1 ^ ((val >>> 1) | (val << (32 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15414().testRorOrInt1Orn(val));
    }
}
