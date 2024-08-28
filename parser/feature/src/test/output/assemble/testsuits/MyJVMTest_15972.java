public class MyJVMTest_15972 {

    static int[] a = { 2, 1765248223, 9, 3, 8, -1860008338, 8, 6, 8, -57545857 };

    static int myKey = -1230516553;

    static int myValue = 9;

    static long mySeed = -7136564083040664480L;

    Object convert(int[] a) {
        float[] b = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (float) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15972().convert(a));
    }
}
