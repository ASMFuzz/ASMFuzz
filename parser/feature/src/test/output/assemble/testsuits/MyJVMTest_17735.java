public class MyJVMTest_17735 {

    static int a = -687224836;

    int test_mulic3(int a) {
        return a * 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17735().test_mulic3(a));
    }
}
