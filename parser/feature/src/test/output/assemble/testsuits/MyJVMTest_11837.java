public class MyJVMTest_11837 {

    static int a = 0;

    static int b = 7;

    int unchecked(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11837().unchecked(a, b));
    }
}
