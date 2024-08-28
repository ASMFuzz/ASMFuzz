public class MyJVMTest_394 {

    void bar() {
        try {
            System.out.println();
        } catch (@TA Exception e) {
        } catch (Throwable t) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_394().bar();
    }
}
