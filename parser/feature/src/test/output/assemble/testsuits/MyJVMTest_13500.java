import java.util.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

public class MyJVMTest_13500 {

    static boolean b = true;

    boolean check(boolean b) {
        if (!b)
            throw new RuntimeException();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13500().check(b);
    }
}
