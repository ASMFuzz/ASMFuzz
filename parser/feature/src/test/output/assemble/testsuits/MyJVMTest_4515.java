import java.util.Locale;

public class MyJVMTest_4515 {

    static String countryParam1 = "|F67|C>tm ";

    static String countryParam2 = "PFWp`k~3+d";

    static String countryParam3 = "&txIQ0i4^$";

    static Locale country = new Locale(countryParam1, countryParam2, countryParam3);

    static String expected = "hVW&jr'UF9";

    String checkCountry(Locale country, String expected) {
        String actual = country.getDisplayCountry();
        if (!expected.equals(actual)) {
            throw new RuntimeException();
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4515().checkCountry(country, expected);
    }
}
