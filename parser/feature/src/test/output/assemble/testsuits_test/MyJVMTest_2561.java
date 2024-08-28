public class MyJVMTest_2561 {

    static int a = 9;

    static int b = -2135993308;

    int unchecked(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2561().unchecked(a, b));
    }
}
