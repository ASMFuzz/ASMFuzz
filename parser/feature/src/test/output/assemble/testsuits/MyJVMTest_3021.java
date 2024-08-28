public class MyJVMTest_3021 {

    static int val = 7;

    int testRorOrInt32Or(int val) {
        return val | ((val >>> 32) | (val << (32 - 32)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3021().testRorOrInt32Or(val));
    }
}
