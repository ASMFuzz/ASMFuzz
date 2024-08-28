import java.io.BufferedReader;

public class MyJVMTest_11783 {

    static String fqn = "<\\ov/4S*`}";

    static int exitValue = 0;

    static String output = "h{\"{^]_#Ra";

    boolean verifyOutput(String output, String fqn) {
        String s1 = String.format("java.util.ServiceConfigurationError: " + "java.net.ContentHandlerFactory: " + "Provider %s could not be instantiated", fqn);
        return output.contains(s1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11783().verifyOutput(output, fqn));
    }
}
