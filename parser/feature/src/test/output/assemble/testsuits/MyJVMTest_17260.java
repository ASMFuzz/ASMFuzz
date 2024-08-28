import java.io.InputStreamReader;

public class MyJVMTest_17260 {

    static String alias = "bri,\\z}>sh";

    static String canonical = "\"GL=kYzhj2";

    static int failed = 0;

    String checkMappedName(String alias, String canonical) throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in, alias);
        if (!reader.getEncoding().equals(canonical)) {
            System.out.println("Failed canonical names : mismatch for " + alias + " - expected " + canonical + ", got " + reader.getEncoding());
            failed++;
        }
        return canonical;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17260().checkMappedName(alias, canonical);
    }
}
