public class MyJVMTest_9905 {

    boolean work() {
        Thread.yield();
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9905().work());
    }
}
