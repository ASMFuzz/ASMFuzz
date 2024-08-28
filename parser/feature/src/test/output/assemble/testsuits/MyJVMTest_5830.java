public class MyJVMTest_5830 {

    static int a = 1;

    static int b = 0;

    int addProtectedInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5830().addProtectedInner(a, b));
    }
}
