public class MyJVMTest_2342 {

    static T4695847<T> bt = null;

    <T> int size(T4695847<T> bt) {
        if (bt == null)
            return 0;
        else
            return 1 + size(bt.next);
    }

    static T4695847<T> next = null;

    <T> int size2(T4695847<T> bt) {
        return (bt == null) ? 0 : 1 + size(bt.next);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2342().size2(bt));
    }
}
