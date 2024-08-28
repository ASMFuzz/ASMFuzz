public class MyJVMTest_2429 {

    void close() {
        ResInNestedExpr.closing(this.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2429().close();
    }
}
