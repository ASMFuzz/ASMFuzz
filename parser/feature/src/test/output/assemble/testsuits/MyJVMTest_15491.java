import java.util.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

public class MyJVMTest_15491 {

    static String parameter = "@dnsV~WM8%";

    static String parameter2 = "2J;'fJZPl\\";

    static T x = null;

    <T> String kitchenSinkFunc(@Named(value = "aName") String parameter, @Named("bName") String parameter2, @ScalarTypesWithDefault T x) throws @TypeAnno("RE") @TypeAnno2("RE2") RuntimeException, NullPointerException, @TypeAnno("AIOOBE") ArrayIndexOutOfBoundsException {
        int i, j, k;
        try {
            System.out.println("calling kitchenSinkFunc " + parameter);
            throw new OkException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parameter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15491().kitchenSinkFunc(parameter, parameter2, x);
    }
}
