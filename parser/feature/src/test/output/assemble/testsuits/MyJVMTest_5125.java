import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_5125 {

    String fooString() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5125().fooString());
    }
}
