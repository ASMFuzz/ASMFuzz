public class MyJVMTest_10000 {

    void test() {
        new LambdaConv12(() -> {
        });
        new LambdaConv12(() -> {
        }) {
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10000().test();
    }
}
