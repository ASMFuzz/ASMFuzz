import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_6567 {

    static String s = "i)>*&ok[Bl";

    static Object o = 6;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitString(String s, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6567().visitString(s, o));
    }
}
