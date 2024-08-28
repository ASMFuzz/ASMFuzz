public class MyJVMTest_16607 {

    static long val = -410571667594336157L;

    long testRorOrLong16And(long val) {
        return val & ((val >>> 16) | (val << (64 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16607().testRorOrLong16And(val));
    }
}
