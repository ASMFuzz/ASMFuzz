public class MyJVMTest_16280 {

    static int[] a = { 6, 176565004, 1575300421, 0, 4, -1440171740, 0, 5, 1595334903, 0 };

    static int myKey = 0;

    static int myValue = 9;

    static long mySeed = 3055707487917969929L;

    Object convert(int[] a) {
        long[] b = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (long) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16280().convert(a));
    }
}
