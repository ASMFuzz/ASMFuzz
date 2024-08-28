public class MyJVMTest_11696 {

    void close() {
        ResInNestedExpr.closing(this.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11696().close();
    }
}
