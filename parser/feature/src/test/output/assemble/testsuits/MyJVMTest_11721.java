public class MyJVMTest_11721 {

    static int val = 9;

    int testRorOrInt16Or(int val) {
        return val | ((val >>> 16) | (val << (32 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11721().testRorOrInt16Or(val));
    }
}
