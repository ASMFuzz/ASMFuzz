public class MyJVMTest_8130 {

    static int val = 7;

    int testRorOrInt32(int val) {
        return (val >>> 32) | (val << (32 - 32));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8130().testRorOrInt32(val));
    }
}
