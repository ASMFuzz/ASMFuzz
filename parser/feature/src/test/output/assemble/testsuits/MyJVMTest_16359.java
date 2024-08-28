public class MyJVMTest_16359 {

    static int[] a = { 7, 9, 4, 0, 0, 0, 0, 0, 2, 6 };

    static int myKey = 0;

    static int myValue = 8;

    static long mySeed = 9223372036854775807L;

    Object convert(int[] a) {
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (char) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16359().convert(a));
    }
}
