import java.text.ChoiceFormat;

public class MyJVMTest_5110 {

    static Format[] subformats = { null, null, null, null, null, null, null, null, null, null };

    static int expected = 1;

    Format[] checkSubformatLength(Format[] subformats, int expected) {
        if (subformats.length != expected) {
            throw new RuntimeException("unexpected subformat length:\n expected: " + expected + "\n   actual: " + subformats.length);
        }
        return subformats;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5110().checkSubformatLength(subformats, expected);
    }
}
