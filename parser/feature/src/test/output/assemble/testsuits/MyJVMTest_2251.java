public class MyJVMTest_2251 {

    static int[] a = { 0, 8, 0, 0, -396656308, 0, 6, 2, 7, -73937013 };

    static int myKey = 2;

    static int myValue = 0;

    static long mySeed = 0;

    Object convert(int[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (double) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2251().convert(a));
    }
}
