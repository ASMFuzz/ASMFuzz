public class MyJVMTest_6783 {

    static int[] a = { 2062589425, 0, 5, 0, 0, 1, 2, 0, 8, 1331070077 };

    static int myKey = 6;

    static int myValue = 6;

    static long mySeed = -9223372036854775808L;

    Object convert(int[] a) {
        long[] b = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (long) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6783().convert(a));
    }
}
