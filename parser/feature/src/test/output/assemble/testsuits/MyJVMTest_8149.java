public class MyJVMTest_8149 {

    static int a = 347108040;

    int test_subc1(int a) {
        return a - 11;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8149().test_subc1(a));
    }
}
