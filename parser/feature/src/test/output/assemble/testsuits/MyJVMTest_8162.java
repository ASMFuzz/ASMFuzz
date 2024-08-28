public class MyJVMTest_8162 {

    static int a = 6;

    int test_mulic3(int a) {
        return a * 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8162().test_mulic3(a));
    }
}
