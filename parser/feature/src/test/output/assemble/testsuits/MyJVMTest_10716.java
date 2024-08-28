public class MyJVMTest_10716 {

    static int ctr = 0;

    static XorShift r = new XorShift();

    static long y = 0;

    int increment(int ctr) {
        return ctr + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10716().increment(ctr));
    }
}
