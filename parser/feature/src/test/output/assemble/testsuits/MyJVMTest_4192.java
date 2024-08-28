public class MyJVMTest_4192 {

    static int var = 1;

    void test_static_field() {
        int v = var;
        int v2 = Test6756768_2a.var;
        int v3 = var;
        var = v3;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4192().test_static_field();
    }
}
