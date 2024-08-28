import java.util.ResourceBundle;
import java.util.Locale;

public class MyJVMTest_10762 {

    static String baseName = "&)mS]F^u0]";

    static String language = "[3j8R\\qbE8";

    static String country = "!sCR(dMC=*";

    static String variant = "0\"F#q]P^te";

    static String[] expectedSuffixes = { "%mQ^[W,n}G", "INN+#EW0M?", "\\w0Zmk{c=*", "`;,QLd5n]1", "fo3<c:l,F]", ";XS?d<O{nB", "i|M>c<t<jP", "If$R{%Fb/a", "a4z@pCD.4\\", "Z3*Xm:\\N.^" };

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
        new MyJVMTest_10762().doTest(baseName, language, country, variant, expectedSuffixes);
    }
}
