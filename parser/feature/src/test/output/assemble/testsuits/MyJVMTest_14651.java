import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.lang.annotation.RetentionPolicy.*;

public class MyJVMTest_14651 {

    static String s = ",&fn<I%!b*";

    static Set<String> stringSet = new HashSet<String>();

    static boolean expected = true;

    int zeroCasesNoDefault(String s, Set<String> stringSet, boolean expected) {
        int failures = 0;
        switch(s) {
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14651().zeroCasesNoDefault(s, stringSet, expected));
    }
}
