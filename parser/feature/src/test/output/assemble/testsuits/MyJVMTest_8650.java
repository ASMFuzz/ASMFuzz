public class MyJVMTest_8650 {

    static int val = 1;

    int testRorOrInt31(int val) {
        return (val >>> 31) | (val << (32 - 31));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8650().testRorOrInt31(val));
    }
}
