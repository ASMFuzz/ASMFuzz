public class MyJVMTest_10252 {

    static int a = 1;

    static int b = 1;

    int m(int a, int b) {
        if (a == b)
            ;
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10252().m(a, b);
    }
}
