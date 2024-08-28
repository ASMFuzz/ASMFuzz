import java.text.ChoiceFormat;
import java.text.Format;
import java.text.DateFormat;

public class MyJVMTest_7592 {

    static Format[] subformats = { null, null, null, null, null, null, null, null, null, null };

    static int index = -460776738;

    static Format expected = new DateFormat();

    Format checkSubformat(Format[] subformats, int index, Format expected) {
        Format subformat = subformats[index];
        if (subformat == expected) {
            return;
        }
        if ((subformat != null) && subformat.equals(expected)) {
            return;
        }
        throw new RuntimeException("found unexpected subformat for argument " + index + ":\n expected: " + expected + "\n   actual: " + subformat);
        return subformat;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7592().checkSubformat(subformats, index, expected);
    }
}
