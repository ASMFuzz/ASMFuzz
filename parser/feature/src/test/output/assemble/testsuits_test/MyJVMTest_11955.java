public class MyJVMTest_11955 {

    static long ctr = 4222904389497306408L;

    static XorShift r = new XorShift();

    long increment(long ctr) {
        return ctr + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11955().increment(ctr));
    }
}
