import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_12228 {

    static Object x = 0;

    String toString(Object x) {
        if (x == null)
            return "null";
        else if (x.getClass().isArray()) {
            StringBuilder sb = new StringBuilder("[");
            int len = Array.getLength(x);
            for (int i = 0; i < len; i++) {
                if (i > 0)
                    sb.append(", ");
                sb.append(toString(Array.get(x, i)));
            }
            sb.append("]");
            return sb.toString();
        } else
            return x.toString();
    }

    static OpenType<?> ostring = SimpleType.STRING, oint = SimpleType.INTEGER, obool = SimpleType.BOOLEAN, olong = SimpleType.LONG, obyte = SimpleType.BYTE, ofloat = SimpleType.FLOAT, odouble = SimpleType.DOUBLE, ostringarray = null, ostringarray2 = null;

    static CompositeType ocomposite = null;

    String string(Object x) {
        if (x == null)
            return null;
        return toString(x);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12228().string(x));
    }
}
