public class MyJVMTest_7863 {

    static TestNullCheck o = null;

    static int f = 0;

    int test1(TestNullCheck o) {
        return o.f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7863().test1(o));
    }
}
