public class MyJVMTest_8699 {

    static A first = null;

    static B second = null;

    <A, B> Pair<A, B> of(A first, B second) {
        return new Pair<A, B>(first, second);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8699().of(first, second));
    }
}
