import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_9650 {

    void fooVoid() {
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9650().fooVoid();
    }
}
