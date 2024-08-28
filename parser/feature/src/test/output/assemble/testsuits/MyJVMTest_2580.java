public class MyJVMTest_2580 {

    static int val = 8;

    int testRorOrInt31And(int val) {
        return val & ((val >>> 31) | (val << (32 - 31)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2580().testRorOrInt31And(val));
    }
}
