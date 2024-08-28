public class MyJVMTest_15728 {

    static int a = 9;

    int test_mulic1(int a) {
        return a * 8;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15728().test_mulic1(a));
    }
}
