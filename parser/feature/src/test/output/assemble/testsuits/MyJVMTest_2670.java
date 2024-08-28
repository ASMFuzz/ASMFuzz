public class MyJVMTest_2670 {

    static long ctr = -1245490986094561790L;

    static XorShift r = new XorShift();

    long increment(long ctr) {
        return ctr + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2670().increment(ctr));
    }
}
