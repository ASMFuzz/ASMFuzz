public class MyJVMTest_9557 {

    static int[] a = { 5, -1290843708, 1017795450, -1955259768, 4, 0, 0, 3, 1605737761, 0 };

    static int fromIndex = 0;

    static int toIndex = 0;

    static int m = 3;

    static int myKey = 6;

    static int myValue = 2;

    static long mySeed = -8498792759986239606L;

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
        new MyJVMTest_9557().prepareSubArray(a, fromIndex, toIndex, m);
    }
}
