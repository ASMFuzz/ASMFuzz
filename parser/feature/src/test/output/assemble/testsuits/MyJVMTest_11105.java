public class MyJVMTest_11105 {

    static X x = null;

    Integer m(X x) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11105().m(x));
    }
}
