public class MyJVMTest_9551 {

    void bar() {
        try {
            System.out.println();
        } catch (@TA Exception e) {
        } catch (Throwable t) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9551().bar();
    }
}
