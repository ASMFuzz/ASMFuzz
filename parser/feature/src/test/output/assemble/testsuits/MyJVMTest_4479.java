public class MyJVMTest_4479 {

    static long[] la = new long[] { -1 };

    long loadL(long[] la) {
        return la[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4479().loadL(la));
    }
}
