public class MyJVMTest_14044 {

    static long val = 8618715469966648057L;

    long testRorOrLong1Eon(long val) {
        return val ^ (-1 ^ ((val >>> 1) | (val << (64 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14044().testRorOrLong1Eon(val));
    }
}
