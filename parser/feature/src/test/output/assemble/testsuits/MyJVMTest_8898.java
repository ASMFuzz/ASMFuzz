public class MyJVMTest_8898 {

    static long val = -2623552354503157881L;

    long testRorOrLong16And(long val) {
        return val & ((val >>> 16) | (val << (64 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8898().testRorOrLong16And(val));
    }
}
