import java.util.Locale;

public class MyJVMTest_12220 {

    static String inCountry = "4w}^^Ljpt,";

    static String localizedName = "8`3~v:xwg(";

    int getCountry(String inCountry, String localizedName) {
        Locale fiLocale = new Locale("fi", "FI");
        Locale inLocale = new Locale("", inCountry);
        if (!inLocale.getDisplayCountry(fiLocale).equals(localizedName)) {
            System.out.println("Country " + inCountry + " should be \"" + localizedName + "\", not \"" + inLocale.getDisplayCountry(fiLocale) + "\"");
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12220().getCountry(inCountry, localizedName));
    }
}
