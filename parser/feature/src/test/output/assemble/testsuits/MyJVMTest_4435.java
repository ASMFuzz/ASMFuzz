import java.io.InputStreamReader;

public class MyJVMTest_4435 {

    static String name = "(FOd0Ksa_X";

    void checkMappedName(String alias, String canonical) throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in, alias);
        if (!reader.getEncoding().equals(canonical)) {
            System.out.println("Failed canonical names : mismatch for " + alias + " - expected " + canonical + ", got " + reader.getEncoding());
            failed++;
        }
    }

    static int failed = 0;

    String checkHistoricalName(String name) throws Exception {
        checkMappedName(name, name);
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4435().checkHistoricalName(name);
    }
}
