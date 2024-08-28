public class MyJVMTest_16221 {

    static int val = 7;

    int testRorOrInt31(int val) {
        return (val >>> 31) | (val << (32 - 31));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16221().testRorOrInt31(val));
    }
}
