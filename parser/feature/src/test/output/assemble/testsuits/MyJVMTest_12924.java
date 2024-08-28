import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_12924 {

    static Element e = null;

    static Object o = 1491915756;

    String visitUnknown(Element e, Object o) {
        return "visitUnknown";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12924().visitUnknown(e, o));
    }
}
