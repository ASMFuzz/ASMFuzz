public class MyJVMTest_8757 {

    static int val = 0;

    int testRorOrInt31Orn(int val) {
        return val | (-1 ^ ((val >>> 31) | (val << (32 - 31))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8757().testRorOrInt31Orn(val));
    }
}
