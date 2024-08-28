public class MyJVMTest_14770 {

    static int a = 5;

    static int b = 3;

    int test_remi(int a, int b) {
        return a % b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14770().test_remi(a, b));
    }
}
