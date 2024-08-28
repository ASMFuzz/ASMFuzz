public class MyJVMTest_6484 {

    static int[] a = { -847710133, 0, 1, 0, -914506703, 0, 0, 9, 0, 0 };

    static int myKey = 2;

    static int myValue = 0;

    static long mySeed = 0;

    Object convert(int[] a) {
        float[] b = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (float) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6484().convert(a));
    }
}
