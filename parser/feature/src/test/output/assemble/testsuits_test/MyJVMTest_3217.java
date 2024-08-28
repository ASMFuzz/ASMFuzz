public class MyJVMTest_3217 {

    static int[] a = { 4, -1388007540, 5, 268071375, 1, 1, 4, 2, 7, 602825787 };

    static int myKey = -1061469908;

    static int myValue = -866229071;

    static long mySeed = 0;

    Object convert(int[] a) {
        short[] b = new short[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (short) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3217().convert(a));
    }
}
