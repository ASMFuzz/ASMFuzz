public class MyJVMTest_12863 {

    static int val = 2;

    int testRorOrInt1Or(int val) {
        return val | ((val >>> 1) | (val << (32 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12863().testRorOrInt1Or(val));
    }
}
