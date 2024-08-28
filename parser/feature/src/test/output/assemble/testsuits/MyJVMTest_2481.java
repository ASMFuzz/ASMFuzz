public class MyJVMTest_2481 {

    static long val = 3262830117429683521L;

    long testRorOrLong16Or(long val) {
        return val | ((val >>> 16) | (val << (64 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2481().testRorOrLong16Or(val));
    }
}
