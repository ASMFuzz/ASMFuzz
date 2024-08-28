import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_3817 {

    static char c = Character.MIN_VALUE;

    static Object o = 1570379103;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitChar(char c, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3817().visitChar(c, o));
    }
}
