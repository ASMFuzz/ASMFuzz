import java.text.Collator;
import java.util.Locale;

public class MyJVMTest_12569 {

    static Collator colLao = Collator.getInstance(new Locale("lo"));

    static String[] textLao = { "\u0ec0", "\u0ec1", "\u0ec2", "\u0ec3", "\u0ec4" };

    void testLao2() {
        System.out.print("Test(Lao 2) .... ");
        for (int i = 0; i < textLao.length; i++) {
            colLao.compare(textLao[i], textLao[i]);
        }
        System.out.println("Passed.");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12569().testLao2();
    }
}
