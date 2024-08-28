public class MyJVMTest_6483 {

    String helpGetUnstartedThreadStackTrace() {
        return "Check return of an empty stack for a thread that has not yet been started.";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6483().helpGetUnstartedThreadStackTrace());
    }
}
