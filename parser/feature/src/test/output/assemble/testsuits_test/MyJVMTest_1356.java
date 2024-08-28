import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import java.lang.annotation.Annotation;

public class MyJVMTest_1356 {

    List<? extends TypeMirror> getBounds() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1356().getBounds());
    }
}
