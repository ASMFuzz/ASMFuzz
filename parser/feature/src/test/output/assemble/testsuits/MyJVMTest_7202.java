import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_7202 {

    Set<? extends Number> fooNumberSet() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7202().fooNumberSet());
    }
}
