public class MyJVMTest_8852 {

    static int val = 3;

    int testRorOrInt16Eon(int val) {
        return val ^ (-1 ^ ((val >>> 16) | (val << (32 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8852().testRorOrInt16Eon(val));
    }
}
