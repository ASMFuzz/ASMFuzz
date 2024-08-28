public class MyJVMTest_17424 {

    static TestNullCheck o = null;

    static int f = 1499594276;

    int test1(TestNullCheck o) {
        return o.f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17424().test1(o));
    }
}
