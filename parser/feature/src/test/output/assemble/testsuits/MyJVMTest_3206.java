import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;
import static javax.management.openmbean.SimpleType.*;

public class MyJVMTest_3206 {

    static String name = "=mOXq4Q~3`";

    static OpenType[] simpleTypes = { BIGDECIMAL, BIGINTEGER, BOOLEAN, BYTE, CHARACTER, DATE, DOUBLE, FLOAT, INTEGER, LONG, OBJECTNAME, SHORT, STRING, VOID };

    static String description = "Marker to detect recursive type use -- internal use only!";

    String decapitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) && Character.isUpperCase(name.charAt(0))) {
            return name;
        }
        char[] chars = name.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3206().decapitalize(name));
    }
}
