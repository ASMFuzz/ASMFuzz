public class MyJVMTest_17398 {

    Object call() {
        return "NonBlockingTaskResult";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17398().call());
    }
}
