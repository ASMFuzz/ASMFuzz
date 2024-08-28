import java.util.Locale;

public class MyJVMTest_4619 {

    static String inLang = "li(>%k9^f?";

    static String localizedName = "HuTgO=m$.y";

    int getLanguage(String inLang, String localizedName) {
        Locale fiLocale = new Locale("fi", "FI");
        Locale inLocale = new Locale(inLang, "");
        if (!inLocale.getDisplayLanguage(fiLocale).equals(localizedName)) {
            System.out.println("Language " + inLang + " should be \"" + localizedName + "\", not \"" + inLocale.getDisplayLanguage(fiLocale) + "\"");
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4619().getLanguage(inLang, localizedName));
    }
}
