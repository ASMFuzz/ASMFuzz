public class MyJVMTest_8985 {

    static int val = 0;

    int testRorOrInt1Eor(int val) {
        return val ^ ((val >>> 1) | (val << (32 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8985().testRorOrInt1Eor(val));
    }
}
