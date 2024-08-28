import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_8300 {

    static String[] args = { "\"%mF8`kuUt", "X\"HqT)f Re", ".Iv70YKLRD", ";0*&SC0:u)", "i4'\" 9K+y~", "THlw6>3kKy", "K}>tAM3]9n", "Y4Y[>!Z?~}", "^D`}1s*8Qe", "-#fxH^)x%'" };

    static String PRINT_ENV_VAR = "--print-env-var=";

    static String PRINT_SYS_PROP = "--print-sys-prop=";

    List<String> printArgs(String[] args) {
        List<String> lines = new ArrayList<>();
        for (String arg : args) {
            if (arg.startsWith(PRINT_ENV_VAR)) {
                String name = arg.substring(PRINT_ENV_VAR.length());
                lines.add(name + "=" + System.getenv(name));
            } else if (arg.startsWith(PRINT_SYS_PROP)) {
                String name = arg.substring(PRINT_SYS_PROP.length());
                lines.add(name + "=" + System.getProperty(name));
            } else {
                throw new IllegalArgumentException();
            }
        }
        return lines;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8300().printArgs(args));
    }
}
