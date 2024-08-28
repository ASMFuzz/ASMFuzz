import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.lang.annotation.RetentionPolicy.*;

public class MyJVMTest_5231 {

    static String s = "oJtgDCupEW";

    static Set<String> stringSet = new HashSet<String>();

    static boolean expected = true;

    int zeroCasesNoDefault(String s, Set<String> stringSet, boolean expected) {
        int failures = 0;
        switch(s) {
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5231().zeroCasesNoDefault(s, stringSet, expected));
    }
}
