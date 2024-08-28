public class MyJVMTest_16968 {

    static int val = -517503050;

    int testRorOrInt32Orn(int val) {
        return val | (-1 ^ ((val >>> 32) | (val << (32 - 32))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16968().testRorOrInt32Orn(val));
    }
}
