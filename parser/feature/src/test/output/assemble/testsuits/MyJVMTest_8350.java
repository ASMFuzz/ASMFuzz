import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_8350 {

    static AnnotatedType annotType1 = null;

    static AnnotatedType annotType2 = null;

    static boolean expected = false;

    static int errors = 0;

    AnnotatedType checkTypesForEquality(AnnotatedType annotType1, AnnotatedType annotType2, boolean expected) {
        boolean comparison = annotType1.equals(annotType2);
        if (comparison) {
            int hash1 = annotType1.hashCode();
            int hash2 = annotType2.hashCode();
            if (hash1 != hash2) {
                errors++;
                System.err.format("Equal AnnotatedTypes with unequal hash codes: %n%s%n%s%n", annotType1.toString(), annotType2.toString());
            }
        }
        if (comparison != expected) {
            errors++;
            System.err.println(annotType1);
            System.err.println(expected ? " is not equal to " : " is equal to ");
            System.err.println(annotType2);
            System.err.println();
        }
        return annotType1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8350().checkTypesForEquality(annotType1, annotType2, expected);
    }
}
