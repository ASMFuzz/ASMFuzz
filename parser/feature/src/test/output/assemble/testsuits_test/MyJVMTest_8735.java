public class MyJVMTest_8735 {

    static int val = 5;

    int testRorOrInt32Eon(int val) {
        return val ^ (-1 ^ ((val >>> 32) | (val << (32 - 32))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8735().testRorOrInt32Eon(val));
    }
}
