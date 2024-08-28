import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_17239 {

    static String why = "q9D[<l/Hj&";

    static String failure = "W[c,%#J$<k";

    static OpenType<?> ostring = SimpleType.STRING, oint = SimpleType.INTEGER, obool = SimpleType.BOOLEAN, olong = SimpleType.LONG, obyte = SimpleType.BYTE, ofloat = SimpleType.FLOAT, odouble = SimpleType.DOUBLE, ostringarray = null, ostringarray2 = null;

    static CompositeType ocomposite = null;

    String fail(String why) {
        System.out.println("FAILED: " + why);
        failure = why;
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17239().fail(why);
    }
}
