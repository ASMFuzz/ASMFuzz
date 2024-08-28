public class MyJVMTest_3101 {

    static int a = 7;

    static int b = 2;

    int test_muli(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3101().test_muli(a, b));
    }
}
