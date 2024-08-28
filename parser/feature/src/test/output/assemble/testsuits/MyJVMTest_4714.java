public class MyJVMTest_4714 {

    static Collection<E> c = null;

    Collection<E> addAll(Collection<E> c) {
        if (c instanceof SortedSet) {
            SortedSet<E> ss = (SortedSet<E>) c;
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4714().addAll(c);
    }
}
