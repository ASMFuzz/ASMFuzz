public class MyJVMTest_4077 {

    static int[] a = { 8, 1309251380, 0, 0, 5, 0, 0, 0, -1107938008, 0 };

    static int[] a2 = { 3, -837419340, 0, 0, 1916319312, 4, 4, 4, 0, -1484131638 };

    static int IGNORE_VALUE = -321;

    boolean areEquals(int[] a, int[] a2) {
        if (a == a2)
            return true;
        if (a == null || a2 == null)
            return false;
        int length = a.length;
        if (a2.length != length)
            return false;
        for (int i = 0; i < length; i++) if (a[i] != a2[i] && a[i] != IGNORE_VALUE && a2[i] != IGNORE_VALUE)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4077().areEquals(a, a2));
    }
}
