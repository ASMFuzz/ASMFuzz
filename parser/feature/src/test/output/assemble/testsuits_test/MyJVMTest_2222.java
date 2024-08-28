public class MyJVMTest_2222 {

    static int f = 0;

    static TestNullCheck static_obj = new TestNullCheck();

    int test2() {
        return static_obj.f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2222().test2());
    }
}
