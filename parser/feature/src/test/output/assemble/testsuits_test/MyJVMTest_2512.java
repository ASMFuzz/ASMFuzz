import java.io.BufferedReader;

public class MyJVMTest_2512 {

    static String fqn = "m--^)hZ@,0";

    static int exitValue = 4;

    static String output = "P!\"21`4r/*";

    boolean verifyOutput(String output, String fqn) {
        String s1 = String.format("java.util.ServiceConfigurationError: " + "java.net.ContentHandlerFactory: " + "Provider %s could not be instantiated", fqn);
        return output.contains(s1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2512().verifyOutput(output, fqn));
    }
}
