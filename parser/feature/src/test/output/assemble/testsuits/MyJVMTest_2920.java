import java.util.Locale;

public class MyJVMTest_2920 {

    static String inCountry = "a$4-AgIMA,";

    static String localizedName = "6Jgn!Fz'<W";

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
        System.out.println(new MyJVMTest_2920().getCountry(inCountry, localizedName));
    }
}
