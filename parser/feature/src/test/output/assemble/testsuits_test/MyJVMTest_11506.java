public class MyJVMTest_11506 {

    static int[] a = { 8, 3, 8, 0, -1425535568, 0, 4, 9, 1828280456, 0 };

    static int myKey = 0;

    static int myValue = 1;

    static long mySeed = 9223372036854775807L;

    Object convert(int[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (double) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11506().convert(a));
    }
}
