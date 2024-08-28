public class MyJVMTest_15492 {

    static Comparable<M> c = null;

    <M> Integer f(Comparable<M> c) {
        return (Integer) c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15492().f(c));
    }
}
