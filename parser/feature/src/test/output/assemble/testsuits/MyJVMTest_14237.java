public class MyJVMTest_14237 {

    static int a = 9;

    static int b = -2135576434;

    int f3(int a, int b) {
        if (a == b) {
        }
        System.out.println("a == b");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14237().f3(a, b);
    }
}
