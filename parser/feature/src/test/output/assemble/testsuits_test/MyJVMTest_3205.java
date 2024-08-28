public class MyJVMTest_3205 {

    static X x = null;

    Number m(X x) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3205().m(x));
    }
}
