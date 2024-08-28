public class MyJVMTest_9597 {

    static int val = 0;

    int testRorOrInt16Eor(int val) {
        return val ^ ((val >>> 16) | (val << (32 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9597().testRorOrInt16Eor(val));
    }
}
