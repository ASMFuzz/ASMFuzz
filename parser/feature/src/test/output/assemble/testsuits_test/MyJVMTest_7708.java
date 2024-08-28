import java.io.InputStreamReader;

public class MyJVMTest_7708 {

    static String alias = "Xy!b!?\\Xeo";

    static String canonical = "dkU81pV/4o";

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
        new MyJVMTest_7708().checkMappedName(alias, canonical);
    }
}
