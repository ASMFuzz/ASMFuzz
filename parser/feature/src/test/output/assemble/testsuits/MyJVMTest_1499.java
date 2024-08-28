public class MyJVMTest_1499 {

    static int ctr = -50741490;

    static XorShift r = new XorShift();

    static long y = 0;

    int increment(int ctr) {
        return ctr + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1499().increment(ctr));
    }
}
