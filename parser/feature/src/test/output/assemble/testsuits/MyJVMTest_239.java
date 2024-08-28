public class MyJVMTest_239 {

    static int a = 1;

    static int b = 1;

    static T i = null;

    int equals(int a, int b) {
        if (a != b)
            throw new Error();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_239().equals(a, b);
    }
}
