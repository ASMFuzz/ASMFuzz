public class MyJVMTest_8268 {

    static int val = -1617774289;

    int testRorOrInt31Eor(int val) {
        return val ^ ((val >>> 31) | (val << (32 - 31)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8268().testRorOrInt31Eor(val));
    }
}
