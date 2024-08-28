public class MyJVMTest_539 {

    static int val = 0;

    int testRorOrInt1Eon(int val) {
        return val ^ (-1 ^ ((val >>> 1) | (val << (32 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_539().testRorOrInt1Eon(val));
    }
}
