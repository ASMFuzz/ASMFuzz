import java.util.Currency;

public class MyJVMTest_16739 {

    static String currencyCode = "nyS ZPd$1)";

    static int digits = 2;

    String testCurrencyDefined(String currencyCode, int digits) {
        Currency currency = Currency.getInstance(currencyCode);
        if (currency.getDefaultFractionDigits() != digits) {
            throw new RuntimeException("[" + currencyCode + "] expected: " + digits + "; got: " + currency.getDefaultFractionDigits());
        }
        return currencyCode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16739().testCurrencyDefined(currencyCode, digits);
    }
}
