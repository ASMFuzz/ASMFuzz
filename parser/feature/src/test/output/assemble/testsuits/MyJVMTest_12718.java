import java.lang.reflect.*;
import java.lang.annotation.*;

public class MyJVMTest_12718 {

    static TypeVariable<?>[] typeVars = null;

    int testTypeVariable(TypeVariable<?>[] typeVars) {
        int errors = 0;
        if (typeVars.length == 0)
            return ++errors;
        for (TypeVariable<?> typeVar : typeVars) {
            try {
                typeVar.getAnnotation(null);
                errors++;
            } catch (NullPointerException npe) {
                ;
            }
            if (typeVar.getAnnotation(SuppressWarnings.class) != null)
                errors++;
            try {
                typeVar.isAnnotationPresent(null);
                errors++;
            } catch (NullPointerException npe) {
                ;
            }
            if (typeVar.isAnnotationPresent(SuppressWarnings.class))
                errors++;
            if (typeVar.getAnnotations().length != 0)
                errors++;
            if (typeVar.getDeclaredAnnotations().length != 0)
                errors++;
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12718().testTypeVariable(typeVars));
    }
}
