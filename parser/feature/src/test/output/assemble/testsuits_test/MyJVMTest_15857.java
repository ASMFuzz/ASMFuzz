import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_15857 {

    Set<String> fooSetString() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15857().fooSetString());
    }
}
