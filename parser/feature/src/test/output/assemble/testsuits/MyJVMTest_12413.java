public class MyJVMTest_12413 {

    static int a = -1632652280;

    static int b = -858189170;

    int test_muli(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12413().test_muli(a, b));
    }
}
