public class MyJVMTest_6580 {

    static A a = null;

    static B b = null;

    <A, B> Pair<A, B> of(A a, B b) {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6580().of(a, b));
    }
}
