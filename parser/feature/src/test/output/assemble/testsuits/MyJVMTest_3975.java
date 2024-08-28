public class MyJVMTest_3975 {

    static A first = null;

    static B second = null;

    <A, B> Pair<A, B> of(A first, B second) {
        return new Pair<A, B>(first, second);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3975().of(first, second));
    }
}
