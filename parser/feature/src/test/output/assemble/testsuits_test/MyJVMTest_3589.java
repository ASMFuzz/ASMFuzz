import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_3589 {

    static Element e = null;

    static Object o = 1;

    String visitUnknown(Element e, Object o) {
        return "visitUnknown";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3589().visitUnknown(e, o));
    }
}
