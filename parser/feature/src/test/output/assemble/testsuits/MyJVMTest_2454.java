public class MyJVMTest_2454 {

    static int val = 7;

    int testRorOrInt16Or(int val) {
        return val | ((val >>> 16) | (val << (32 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2454().testRorOrInt16Or(val));
    }
}
