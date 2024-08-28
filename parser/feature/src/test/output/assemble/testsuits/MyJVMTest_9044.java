public class MyJVMTest_9044 {

    void fatal() {
        throw new RuntimeException("Got a non-null stream metadata format!");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9044().fatal();
    }
}
