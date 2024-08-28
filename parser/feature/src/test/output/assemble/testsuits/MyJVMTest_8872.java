public class MyJVMTest_8872 {

    static int val = 0;

    int testRorOrInt16And(int val) {
        return val & ((val >>> 16) | (val << (32 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8872().testRorOrInt16And(val));
    }
}
