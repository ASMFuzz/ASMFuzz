public class MyJVMTest_6252 {

    static int a = 543941012;

    int test_mulic1(int a) {
        return a * 8;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6252().test_mulic1(a));
    }
}
