public class MyJVMTest_12884 {

    static int val = -1493564570;

    int testRorOrInt16And(int val) {
        return val & ((val >>> 16) | (val << (32 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12884().testRorOrInt16And(val));
    }
}
