public class MyJVMTest_15276 {

    static int a = 7;

    static int b = 3;

    int addProtectedInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15276().addProtectedInner(a, b));
    }
}
