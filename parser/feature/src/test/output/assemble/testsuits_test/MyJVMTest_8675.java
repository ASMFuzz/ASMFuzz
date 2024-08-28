import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_8675 {

    static String[] args = { "-blFe@>6*m", "FOuxY?jxB(", "VV,R;1l%t ", "&)&ZXQR\":2", "g#T}IF2&tM", "EI5/AYeJR.", "I)[4J/GAh4", "@b-G%<OC75", ";m&PfwN=-;", "\\zrHB6ZgAK" };

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
        System.out.println(new MyJVMTest_8675().printArgs(args));
    }
}
