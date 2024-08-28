import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.modelmbean.*;

public class MyJVMTest_3947 {

    static Object[] array = { "hello", "world" };

    Object[] getArray() {
        return (Object[]) array.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3947().getArray()));
    }
}
