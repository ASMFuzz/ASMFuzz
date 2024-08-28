public class MyJVMTest_8737 {

    static int val = 0;

    int testRorOrInt32(int val) {
        return (val >>> 32) | (val << (32 - 32));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8737().testRorOrInt32(val));
    }
}
