import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_9712 {

    TypeKind getKind() {
        return TypeKind.INTERSECTION;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9712().getKind());
    }
}
