public class MyJVMTest_3730 {

    static int val = 52200569;

    int testRorOrInt32Eon(int val) {
        return val ^ (-1 ^ ((val >>> 32) | (val << (32 - 32))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3730().testRorOrInt32Eon(val));
    }
}
