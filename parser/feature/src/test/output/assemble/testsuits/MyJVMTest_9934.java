public class MyJVMTest_9934 {

    static E[] a = { null, null, null, null, null, null, null, null, null, null };

    static E e = null;

    <E> E bug(E[] a, E e) {
        java.util.Arrays.fill(a, 0, 100, e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9934().bug(a, e);
    }
}
