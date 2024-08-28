public class MyJVMTest_1427 {

    static int a = -298211048;

    static int b = 1;

    int unchecked(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1427().unchecked(a, b));
    }
}
