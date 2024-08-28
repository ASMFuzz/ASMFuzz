public class MyJVMTest_12327 {

    static int val = -1670421953;

    int testRorOrInt32Or(int val) {
        return val | ((val >>> 32) | (val << (32 - 32)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12327().testRorOrInt32Or(val));
    }
}
