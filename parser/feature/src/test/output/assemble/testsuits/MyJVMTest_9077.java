public class MyJVMTest_9077 {

    static int val = 0;

    int testRorOrInt1Eon(int val) {
        return val ^ (-1 ^ ((val >>> 1) | (val << (32 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9077().testRorOrInt1Eon(val));
    }
}
