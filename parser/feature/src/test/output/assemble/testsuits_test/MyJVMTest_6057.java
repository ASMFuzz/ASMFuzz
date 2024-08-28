public class MyJVMTest_6057 {

    static String fqn = "D--T;qKgM3";

    static int exitValue = 5;

    static String output = ",mSw;dB=}E";

    String stackTraceStringForBrokenFactory(String fqn) {
        return "Exception in thread \"main\" java.lang.RuntimeException: " + "This is a broken factory. It is supposed to throw this exception.";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6057().stackTraceStringForBrokenFactory(fqn));
    }
}
