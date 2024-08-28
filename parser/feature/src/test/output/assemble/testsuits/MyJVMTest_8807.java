public class MyJVMTest_8807 {

    static int val = 365520615;

    int testRorOrInt16(int val) {
        return (val >>> 16) | (val << (32 - 16));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8807().testRorOrInt16(val));
    }
}
