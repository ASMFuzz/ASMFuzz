public class MyJVMTest_6854 {

    static int[] a = { 7, 7, 3, 1, 1, -1045206278, 2, 0, 8, 8 };

    static int myKey = 9;

    static int myValue = 1;

    static long mySeed = 0;

    Object convert(int[] a) {
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (char) a[i];
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6854().convert(a));
    }
}
