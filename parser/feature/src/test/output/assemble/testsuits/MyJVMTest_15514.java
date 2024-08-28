public class MyJVMTest_15514 {

    static String fqn = "NhMY\"OC%?n";

    static int exitValue = -344805001;

    static String output = "h>?L/Dm*6q";

    String stackTraceStringForBrokenFactory(String fqn) {
        return "Exception in thread \"main\" java.lang.RuntimeException: " + "This is a broken factory. It is supposed to throw this exception.";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15514().stackTraceStringForBrokenFactory(fqn));
    }
}
