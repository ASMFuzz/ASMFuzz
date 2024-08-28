public class MyJVMTest_400 {

    static int[] a = { 0, 5, 0, 0, 0, 5, 0, 1339127970, -1299415717, 946987778 };

    static int fromIndex = 1;

    static int toIndex = 5;

    static int m = 2;

    static int myKey = 1013143548;

    static int myValue = 1689509381;

    static long mySeed = 9223372036854775807L;

    int[] prepareSubArray(int[] a, int fromIndex, int toIndex, int m) {
        for (int i = 0; i < fromIndex; i++) {
            a[i] = 0xDEDA;
        }
        int middle = (fromIndex + toIndex) >>> 1;
        int k = 0;
        for (int i = fromIndex; i < middle; i++) {
            a[i] = k++;
        }
        for (int i = middle; i < toIndex; i++) {
            a[i] = k--;
        }
        for (int i = toIndex; i < a.length; i++) {
            a[i] = 0xBABA;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_400().prepareSubArray(a, fromIndex, toIndex, m);
    }
}
