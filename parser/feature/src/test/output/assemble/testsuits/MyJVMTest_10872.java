public class MyJVMTest_10872 {

    static int[] a = { 9, -1588151541, 9, 8, 2, 1, 6, -1647317080, 5, 2 };

    static int myKey = -53189267;

    static int myValue = 0;

    static long mySeed = -5627744265816690311L;

    Object convert(int[] a) {
        byte[] b = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (byte) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10872().convert(a));
    }
}
