public class MyJVMTest_6862 {

    static int val = 0;

    int testRorOrInt16(int val) {
        return (val >>> 16) | (val << (32 - 16));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6862().testRorOrInt16(val));
    }
}
