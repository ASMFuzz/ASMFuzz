import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_2372 {

    static Object entries = -1059126338;

    static OpenType<?> ostring = SimpleType.STRING, oint = SimpleType.INTEGER, obool = SimpleType.BOOLEAN, olong = SimpleType.LONG, obyte = SimpleType.BYTE, ofloat = SimpleType.FLOAT, odouble = SimpleType.DOUBLE, ostringarray = null, ostringarray2 = null;

    static CompositeType ocomposite = null;

    Descriptor descriptor(Object... entries) {
        if (entries.length % 2 != 0)
            throw new RuntimeException("Odd length descriptor entries");
        String[] names = new String[entries.length / 2];
        Object[] values = new Object[entries.length / 2];
        for (int i = 0; i < entries.length; i += 2) {
            names[i / 2] = (String) entries[i];
            values[i / 2] = entries[i + 1];
        }
        return new ImmutableDescriptor(names, values);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2372().descriptor(entries));
    }
}
