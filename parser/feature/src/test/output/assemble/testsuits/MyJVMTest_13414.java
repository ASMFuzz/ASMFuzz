import javax.net.ssl.*;

public class MyJVMTest_13414 {

    static String candidate = "4dbA[B{.=s";

    String trimQuotes(String candidate) {
        if (candidate != null && candidate.length() != 0) {
            if (candidate.length() > 1 && candidate.charAt(0) == '"' && candidate.charAt(candidate.length() - 1) == '"') {
                return candidate.substring(1, candidate.length() - 1);
            }
        }
        return candidate;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13414().trimQuotes(candidate));
    }
}
