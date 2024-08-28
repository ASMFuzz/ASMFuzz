public class MyJVMTest_1876 {

    static X x = null;

    Integer m(X x) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1876().m(x));
    }
}
