public class MyJVMTest_18171 {

    static int ctr = 0;

    static XorShift r = new XorShift();

    int increment(int ctr) {
        return ctr + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18171().increment(ctr));
    }
}
