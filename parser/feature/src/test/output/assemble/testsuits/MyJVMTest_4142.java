public class MyJVMTest_4142 {

    static int val = 1;

    int testRorOrInt1(int val) {
        return (val >>> 1) | (val << (32 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4142().testRorOrInt1(val));
    }
}
