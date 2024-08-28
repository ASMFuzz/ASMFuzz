public class MyJVMTest_13435 {

    static int[] a = { 0, 0, 8, 7, -655805498, 0, 1, 0, -1215450485, 3 };

    static int[] a2 = { 7, 1, 6, 3, 5, 0, 9, 3, -1046093382, -1705027369 };

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
        System.out.println(new MyJVMTest_13435().areEquals(a, a2));
    }
}
