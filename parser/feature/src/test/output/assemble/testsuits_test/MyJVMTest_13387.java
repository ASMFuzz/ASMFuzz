public class MyJVMTest_13387 {

    static short[] sa = new short[] { -1 };

    static long MASK = 0;

    long doload(short[] sa) {
        return sa[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13387().doload(sa));
    }
}
