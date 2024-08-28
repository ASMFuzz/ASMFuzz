import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_11160 {

    static T[] array = { 24, -27, 57, 118, -102, -23, -40, -96, 48, 95 };

    static OpenType<?> ostring = SimpleType.STRING, oint = SimpleType.INTEGER, obool = SimpleType.BOOLEAN, olong = SimpleType.LONG, obyte = SimpleType.BYTE, ofloat = SimpleType.FLOAT, odouble = SimpleType.DOUBLE, ostringarray = null, ostringarray2 = null;

    static CompositeType ocomposite = null;

    <T> Set<T> arraySet(T[] array) {
        return new HashSet<T>(Arrays.asList(array));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11160().arraySet(array));
    }
}
