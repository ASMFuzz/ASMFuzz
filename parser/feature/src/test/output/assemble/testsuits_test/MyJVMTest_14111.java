public class MyJVMTest_14111 {

    static Collection<E> c = null;

    Collection<E> addAll(Collection<E> c) {
        if (c instanceof SortedSet) {
            SortedSet<E> ss = (SortedSet<E>) c;
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14111().addAll(c);
    }
}
