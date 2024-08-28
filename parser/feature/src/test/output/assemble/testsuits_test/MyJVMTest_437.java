public class MyJVMTest_437 {

    static int val = 6;

    int testRorOrInt16Eor(int val) {
        return val ^ ((val >>> 16) | (val << (32 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_437().testRorOrInt16Eor(val));
    }
}
