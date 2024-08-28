import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_7687 {

    static String why = "cs^n8LdT!Z";

    static String failure = "G7&B =CI(O";

    static OpenType<?> ostring = SimpleType.STRING, oint = SimpleType.INTEGER, obool = SimpleType.BOOLEAN, olong = SimpleType.LONG, obyte = SimpleType.BYTE, ofloat = SimpleType.FLOAT, odouble = SimpleType.DOUBLE, ostringarray = null, ostringarray2 = null;

    static CompositeType ocomposite = null;

    String fail(String why) {
        System.out.println("FAILED: " + why);
        failure = why;
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7687().fail(why);
    }
}
