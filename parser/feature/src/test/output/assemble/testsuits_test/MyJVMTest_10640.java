public class MyJVMTest_10640 {

    static int a = 2;

    static int b = 255898757;

    int unchecked(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10640().unchecked(a, b));
    }
}
