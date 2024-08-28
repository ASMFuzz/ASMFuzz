import java.util.Currency;

public class MyJVMTest_7216 {

    static String currencyCode = "0@qwSOTyL}";

    static int digits = 0;

    String testCurrencyDefined(String currencyCode, int digits) {
        Currency currency = Currency.getInstance(currencyCode);
        if (currency.getDefaultFractionDigits() != digits) {
            throw new RuntimeException("[" + currencyCode + "] expected: " + digits + "; got: " + currency.getDefaultFractionDigits());
        }
        return currencyCode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7216().testCurrencyDefined(currencyCode, digits);
    }
}
