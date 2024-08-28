import java.util.Currency;
import java.util.Locale;

public class MyJVMTest_14717 {

    static String country = "Z~bQ\\(`Uj/";

    static String currencyCode = "rX}NL#vMgT";

    static int digits = 0;

    void testCurrencyDefined(String currencyCode, int digits) {
        Currency currency = Currency.getInstance(currencyCode);
        if (currency.getDefaultFractionDigits() != digits) {
            throw new RuntimeException("[" + currencyCode + "] expected: " + digits + "; got: " + currency.getDefaultFractionDigits());
        }
    }

    String testCountryCurrency(String country, String currencyCode, int digits) {
        testCurrencyDefined(currencyCode, digits);
        Currency currency = Currency.getInstance(new Locale("", country));
        if (!currency.getCurrencyCode().equals(currencyCode)) {
            throw new RuntimeException("[" + country + "] expected: " + currencyCode + "; got: " + currency.getCurrencyCode());
        }
        return currencyCode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14717().testCountryCurrency(country, currencyCode, digits);
    }
}
