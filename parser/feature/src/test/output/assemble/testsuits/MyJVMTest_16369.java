public class MyJVMTest_16369 {

    static int val = 8;

    int testRorOrInt16(int val) {
        return (val >>> 16) | (val << (32 - 16));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16369().testRorOrInt16(val));
    }
}
