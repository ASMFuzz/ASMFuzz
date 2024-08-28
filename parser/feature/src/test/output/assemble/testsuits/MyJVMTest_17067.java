public class MyJVMTest_17067 {

    static T[] a = { Float.MIN_VALUE, Float.MIN_VALUE, 0.0105752945f, 0.90832615f, Float.NEGATIVE_INFINITY, 0.3932209f, Float.MAX_VALUE, 0f, 0f, Float.NaN };

    static Comparator<U> c = null;

    <U, T extends U> Comparator<U> sort(T[] a, Comparator<U> c) {
        throw new Error();
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17067().sort(a, c);
    }
}
