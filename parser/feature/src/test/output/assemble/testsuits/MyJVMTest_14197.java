public class MyJVMTest_14197 {

    static int a = 8;

    int test_mulic4(int a) {
        return a * 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14197().test_mulic4(a));
    }
}
