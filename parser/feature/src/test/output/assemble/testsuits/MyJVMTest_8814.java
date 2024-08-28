public class MyJVMTest_8814 {

    static int val = 0;

    int testRorOrInt16Or(int val) {
        return val | ((val >>> 16) | (val << (32 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8814().testRorOrInt16Or(val));
    }
}
