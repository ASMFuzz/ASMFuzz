public class MyJVMTest_15971 {

    String helpGetUnstartedThreadStackTrace() {
        return "Check return of an empty stack for a thread that has not yet been started.";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15971().helpGetUnstartedThreadStackTrace());
    }
}
