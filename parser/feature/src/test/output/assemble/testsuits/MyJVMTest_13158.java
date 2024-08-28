import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_13158 {

    static char c = Character.MAX_VALUE;

    static Object o = 3;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitChar(char c, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13158().visitChar(c, o));
    }
}
