public class MyJVMTest_15216 {

    static int val = 1165231849;

    int testRorOrInt16Orn(int val) {
        return val | (-1 ^ ((val >>> 16) | (val << (32 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15216().testRorOrInt16Orn(val));
    }
}
