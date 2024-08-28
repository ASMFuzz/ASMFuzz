import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_17227 {

    int foo() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17227().foo());
    }
}
