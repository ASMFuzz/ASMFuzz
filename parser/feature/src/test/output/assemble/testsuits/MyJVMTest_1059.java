public class MyJVMTest_1059 {

    static int a = 3;

    static int b = 2;

    int m(int a, int b) {
        if (a == b)
            ;
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1059().m(a, b);
    }
}
