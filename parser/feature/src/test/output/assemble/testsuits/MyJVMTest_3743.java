import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_3743 {

    static List<? extends AnnotationValue> vals = new ArrayList<? extends AnnotationValue>();

    static Object o = 4;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitArray(List<? extends AnnotationValue> vals, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3743().visitArray(vals, o));
    }
}
