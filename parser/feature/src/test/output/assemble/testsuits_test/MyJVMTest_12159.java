public class MyJVMTest_12159 {

    String helpGetDeadThreadStackTrace() {
        return "Check return of an empty stack for a dead thread.";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12159().helpGetDeadThreadStackTrace());
    }
}
