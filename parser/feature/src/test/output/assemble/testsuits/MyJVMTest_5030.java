public class MyJVMTest_5030 {

    static int a = 5;

    int test_mulic2(int a) {
        return a * 9;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5030().test_mulic2(a));
    }
}
