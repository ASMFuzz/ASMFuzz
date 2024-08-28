public class MyJVMTest_5130 {

    static long val = 9223372036854775807L;

    long testRorOrLong64And(long val) {
        return val & ((val >>> 64) | (val << (64 - 64)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5130().testRorOrLong64And(val));
    }
}
