public class MyJVMTest_1650 {

    static int[] a = { 6, 1470061148, -1205505652, 9, 891684193, 3, 1290176541, 0, 0, 4 };

    static int myKey = -710190285;

    static int myValue = 4;

    static long mySeed = -4641690699271732509L;

    Object convert(int[] a) {
        byte[] b = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (byte) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1650().convert(a));
    }
}
