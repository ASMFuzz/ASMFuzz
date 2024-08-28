import java.util.Locale;

public class MyJVMTest_13903 {

    static String countryParam1 = "v,2VNK\")@k";

    static Locale country = new Locale(countryParam1);

    static String expected = "XrK1Q_vN,#";

    String checkCountry(Locale country, String expected) {
        String actual = country.getDisplayCountry();
        if (!expected.equals(actual)) {
            throw new RuntimeException();
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13903().checkCountry(country, expected);
    }
}
