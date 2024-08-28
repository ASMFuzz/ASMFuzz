public class MyJVMTest_9704 {

    static int val = 4;

    int testRorOrInt1Eon(int val) {
        return val ^ (-1 ^ ((val >>> 1) | (val << (32 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9704().testRorOrInt1Eon(val));
    }
}
