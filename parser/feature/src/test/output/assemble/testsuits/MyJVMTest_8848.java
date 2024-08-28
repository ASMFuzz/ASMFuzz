public class MyJVMTest_8848 {

    static long val = -4177486074187202949L;

    long testRorOrLong1Or(long val) {
        return val | ((val >>> 1) | (val << (64 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8848().testRorOrLong1Or(val));
    }
}
