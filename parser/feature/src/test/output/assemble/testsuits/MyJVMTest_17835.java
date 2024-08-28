import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_17835 {

    static Element e = null;

    static Object o = 0;

    String visit(Element e, Object o) {
        return "visit";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17835().visit(e, o));
    }
}
