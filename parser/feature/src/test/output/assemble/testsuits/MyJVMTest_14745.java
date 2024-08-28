public class MyJVMTest_14745 {

    static int[] a = { 3, 7, 2, -1304588590, 1758891065, 1217464699, 9, 0, -1601864218, 0 };

    static int myKey = -1509527230;

    static int myValue = 8;

    static long mySeed = 4608049343282024053L;

    Object convert(int[] a) {
        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = new Integer(a[i]);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14745().convert(a));
    }
}
