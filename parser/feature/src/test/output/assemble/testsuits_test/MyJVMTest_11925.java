import java.util.*;

public class MyJVMTest_11925 {

    static String[] args = { "!?:]f>Y1r0", "hvl`B-##QQ", "HG&cU:Mt#j", ",CVonWd$]M", ":[F6ro+uaw", "[3j7gE\"j==", "XSJn'2=uI\\", ";+*4Nnfa+a", "_UZ5ZcD-*C", "?kg%B/r`Dr" };

    static int i = -883016971;

    static int defaultValue = 0;

    int intArg(String[] args, int i, int defaultValue) {
        return args.length > i ? Integer.parseInt(args[i]) : defaultValue;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11925().intArg(args, i, defaultValue));
    }
}
