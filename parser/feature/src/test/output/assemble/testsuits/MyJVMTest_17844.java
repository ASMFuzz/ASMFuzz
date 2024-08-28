public class MyJVMTest_17844 {

    static int val = 0;

    int testRorOrInt31Eor(int val) {
        return val ^ ((val >>> 31) | (val << (32 - 31)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17844().testRorOrInt31Eor(val));
    }
}
