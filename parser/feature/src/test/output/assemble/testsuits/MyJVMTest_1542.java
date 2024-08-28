import java.util.ResourceBundle;
import java.util.Locale;

public class MyJVMTest_1542 {

    static String baseName = "yqSwt@2*3m";

    static String language = "%f3]&Jnu/p";

    static String country = "kuqaF-R!Rv";

    static String variant = "TMwSQP0#OU";

    static String[] expectedSuffixes = { "Dp,xQfXdua", "%/u?_uBQ*0", "~5XK/fogZp", "~}{G$`_?q_", "@&+]H3'00W", "qhQ/VQ]KT1", "=pnZ9<O>H@", "4mo9wGW>av", "4%2 O}MR`L", "Bm_,%9{ QS" };

    String doTest(String baseName, String language, String country, String variant, String[] expectedSuffixes) {
        System.out.print("Looking for " + baseName + " \"" + language + "\", \"" + country + "\", \"" + variant + "\"");
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, new Locale(language, country, variant));
        System.out.print(" => got ");
        String previousName = null;
        int nameCount = 0;
        for (int i = 3; i >= 0; i--) {
            String name = bundle.getString("name" + i);
            if (!name.equals(previousName)) {
                if (previousName != null) {
                    System.out.print(", ");
                }
                System.out.print(name);
                if (!name.equals(baseName + expectedSuffixes[nameCount++])) {
                    System.out.println();
                    throw new RuntimeException("Error: got unexpected resource bundle");
                }
                previousName = name;
            }
        }
        System.out.println();
        if (nameCount != expectedSuffixes.length) {
            throw new RuntimeException("Error: parent chain too short");
        }
        return baseName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1542().doTest(baseName, language, country, variant, expectedSuffixes);
    }
}
