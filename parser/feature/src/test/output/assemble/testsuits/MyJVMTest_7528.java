public class MyJVMTest_7528 {

    static T[] a = { 45, 126, -87, 41, -62, 94, 43, -116, 68, 106 };

    static Comparator<U> c = null;

    <U, T extends U> Comparator<U> sort(T[] a, Comparator<U> c) {
        throw new Error();
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7528().sort(a, c);
    }
}
