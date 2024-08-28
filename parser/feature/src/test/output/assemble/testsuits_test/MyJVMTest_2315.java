public class MyJVMTest_2315 {

    static int val = 7;

    int testRorOrInt16Eon(int val) {
        return val ^ (-1 ^ ((val >>> 16) | (val << (32 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2315().testRorOrInt16Eon(val));
    }
}
