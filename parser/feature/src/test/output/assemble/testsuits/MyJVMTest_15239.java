import java.text.Collator;
import java.util.Locale;

public class MyJVMTest_15239 {

    static Collator colThai = Collator.getInstance(new Locale("th"));

    static String[] textThai = { "\u0e40", "\u0e41", "\u0e42", "\u0e43", "\u0e44" };

    void testThai2() {
        System.out.print("Test(Thai 2) .... ");
        for (int i = 0; i < textThai.length; i++) {
            colThai.getCollationKey(textThai[i]);
        }
        System.out.println("Passed.");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15239().testThai2();
    }
}
