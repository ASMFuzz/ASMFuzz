public class MyJVMTest_821 {

    void test() {
        new LambdaConv12(() -> {
        });
        new LambdaConv12(() -> {
        }) {
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_821().test();
    }
}
