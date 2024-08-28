public class MyJVMTest_3350 {

    static int a = -380377714;

    static int b = 3;

    int test_addi(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3350().test_addi(a, b));
    }
}
