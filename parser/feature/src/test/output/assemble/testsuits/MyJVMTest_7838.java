public class MyJVMTest_7838 {

    Object call() {
        return "NonBlockingTaskResult";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7838().call());
    }
}
