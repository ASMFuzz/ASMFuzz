public class MyJVMTest_5960 {

    static int val = 5;

    int testRorOrInt1Orn(int val) {
        return val | (-1 ^ ((val >>> 1) | (val << (32 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5960().testRorOrInt1Orn(val));
    }
}
