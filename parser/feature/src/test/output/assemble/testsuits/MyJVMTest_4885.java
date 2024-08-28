public class MyJVMTest_4885 {

    static long ctr = -8161576792993132459L;

    static XorShift r = new XorShift();

    static long y = 9223372036854775807L;

    long increment(long ctr) {
        return ctr + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4885().increment(ctr));
    }
}
