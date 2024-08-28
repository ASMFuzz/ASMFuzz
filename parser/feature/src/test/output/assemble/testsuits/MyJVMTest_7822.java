public class MyJVMTest_7822 {

    static E[] a = { null, null, null, null, null, null, null, null, null, null };

    <E extends Integer> E[] doit(E[] a) {
        System.out.println(a[0] / 4);
        for (int i : a) System.out.println(i / 4);
        for (E e : a) {
            E f = e;
            System.out.println(e / 4);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7822().doit(a);
    }
}
