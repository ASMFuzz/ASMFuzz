public class MyJVMTest_3529 {

    static int val = 0;

    int testRorOrInt1Or(int val) {
        return val | ((val >>> 1) | (val << (32 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3529().testRorOrInt1Or(val));
    }
}
