import java.text.Collator;
import java.util.Locale;

public class MyJVMTest_2991 {

    static Collator colThai = Collator.getInstance(new Locale("th"));

    static String[] textThai = { "\u0e40", "\u0e41", "\u0e42", "\u0e43", "\u0e44" };

    void testThai1() {
        System.out.print("Test(Thai 1) .... ");
        for (int i = 0; i < textThai.length; i++) {
            colThai.compare(textThai[i], textThai[i]);
        }
        System.out.println("Passed.");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2991().testThai1();
    }
}
