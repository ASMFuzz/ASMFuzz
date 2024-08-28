public class MyJVMTest_9042 {

    static int val = 5;

    int testRorOrInt16Bic(int val) {
        return val & (-1 ^ ((val >>> 16) | (val << (32 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9042().testRorOrInt16Bic(val));
    }
}
