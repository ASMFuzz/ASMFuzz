public class MyJVMTest_10541 {

    static int val = -1977161313;

    int testRorOrInt1And(int val) {
        return val & ((val >>> 1) | (val << (32 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10541().testRorOrInt1And(val));
    }
}
