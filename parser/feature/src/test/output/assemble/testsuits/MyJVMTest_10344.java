public class MyJVMTest_10344 {

    static int a = 5;

    static int b = 0;

    int unchecked(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10344().unchecked(a, b));
    }
}
