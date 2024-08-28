public class MyJVMTest_5322 {

    static int[] a = { 3, 0, 7, 5, 1, 0, 0, 1451927552, -588814583, 2 };

    static int myKey = 5;

    static int myValue = 2;

    static long mySeed = 0;

    Object convert(int[] a) {
        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = new Integer(a[i]);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5322().convert(a));
    }
}
