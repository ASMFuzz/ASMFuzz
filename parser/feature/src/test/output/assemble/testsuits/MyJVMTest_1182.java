public class MyJVMTest_1182 {

    static int val = 0;

    int testRorOrInt31Orn(int val) {
        return val | (-1 ^ ((val >>> 31) | (val << (32 - 31))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1182().testRorOrInt31Orn(val));
    }
}
