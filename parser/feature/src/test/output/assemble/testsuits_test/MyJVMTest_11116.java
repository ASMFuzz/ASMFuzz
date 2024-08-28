public class MyJVMTest_11116 {

    static Comparable<?> c = null;

    Integer g(Comparable<?> c) {
        return (Integer) c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11116().g(c));
    }
}
