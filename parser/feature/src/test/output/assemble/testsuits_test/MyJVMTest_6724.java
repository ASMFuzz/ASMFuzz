public class MyJVMTest_6724 {

    static int val = 2;

    int testRorOrInt31(int val) {
        return (val >>> 31) | (val << (32 - 31));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6724().testRorOrInt31(val));
    }
}
