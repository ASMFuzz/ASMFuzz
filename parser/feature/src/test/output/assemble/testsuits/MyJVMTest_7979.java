public class MyJVMTest_7979 {

    static int val = 0;

    int testRorOrInt16Bic(int val) {
        return val & (-1 ^ ((val >>> 16) | (val << (32 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7979().testRorOrInt16Bic(val));
    }
}
