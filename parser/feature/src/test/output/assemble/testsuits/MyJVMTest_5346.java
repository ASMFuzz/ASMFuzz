public class MyJVMTest_5346 {

    static int a = 7;

    static int b = 5;

    int test_remi(int a, int b) {
        return a % b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5346().test_remi(a, b));
    }
}
