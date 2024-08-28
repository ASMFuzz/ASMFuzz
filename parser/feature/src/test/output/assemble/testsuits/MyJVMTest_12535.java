public class MyJVMTest_12535 {

    static int[] a = { 8, 0, 0, 1812727760, 5, 0, -429852220, 4, 6, 9 };

    static int myKey = 0;

    static int myValue = 2;

    static long mySeed = 7906827391994532014L;

    Object convert(int[] a) {
        short[] b = new short[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (short) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12535().convert(a));
    }
}
