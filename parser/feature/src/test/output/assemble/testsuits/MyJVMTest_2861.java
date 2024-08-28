public class MyJVMTest_2861 {

    String helpGetDeadThreadStackTrace() {
        return "Check return of an empty stack for a dead thread.";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2861().helpGetDeadThreadStackTrace());
    }
}
