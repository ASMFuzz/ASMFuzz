import java.util.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

public class MyJVMTest_4139 {

    static boolean b = false;

    boolean check(boolean b) {
        if (!b)
            throw new RuntimeException();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4139().check(b);
    }
}
