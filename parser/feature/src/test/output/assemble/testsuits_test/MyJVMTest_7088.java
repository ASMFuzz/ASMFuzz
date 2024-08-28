public class MyJVMTest_7088 {

    static long val = 0;

    long testRorOrLong16And(long val) {
        return val & ((val >>> 16) | (val << (64 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7088().testRorOrLong16And(val));
    }
}
