import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.modelmbean.*;

public class MyJVMTest_10027 {

    static Object[] array = { "hello", "world" };

    Object[] tweakArray(Object[] array) {
        this.array = (Object[]) array.clone();
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10027().tweakArray(array);
    }
}
