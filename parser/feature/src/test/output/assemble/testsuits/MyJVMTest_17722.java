public class MyJVMTest_17722 {

    static int a = 5;

    int test_subc1(int a) {
        return a - 11;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17722().test_subc1(a));
    }
}
