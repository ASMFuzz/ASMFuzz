public class MyJVMTest_11575 {

    static int val = 8;

    int testRorOrInt16Eon(int val) {
        return val ^ (-1 ^ ((val >>> 16) | (val << (32 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11575().testRorOrInt16Eon(val));
    }
}
