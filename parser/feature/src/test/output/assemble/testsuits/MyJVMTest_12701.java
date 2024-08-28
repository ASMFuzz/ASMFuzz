public class MyJVMTest_12701 {

    void fatal() {
        throw new RuntimeException("Got a non-null stream metadata format!");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12701().fatal();
    }
}
