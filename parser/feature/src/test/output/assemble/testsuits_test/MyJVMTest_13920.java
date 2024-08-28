public class MyJVMTest_13920 {

    static int val = 95351854;

    int testRorOrInt1Eor(int val) {
        return val ^ ((val >>> 1) | (val << (32 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13920().testRorOrInt1Eor(val));
    }
}
