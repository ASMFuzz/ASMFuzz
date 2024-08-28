public class MyJVMTest_11859 {

    static int val = 0;

    int testRorOrInt31And(int val) {
        return val & ((val >>> 31) | (val << (32 - 31)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11859().testRorOrInt31And(val));
    }
}
