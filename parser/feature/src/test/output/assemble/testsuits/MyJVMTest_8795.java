public class MyJVMTest_8795 {

    static int val = -1089468673;

    int testRorOrInt31And(int val) {
        return val & ((val >>> 31) | (val << (32 - 31)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8795().testRorOrInt31And(val));
    }
}
