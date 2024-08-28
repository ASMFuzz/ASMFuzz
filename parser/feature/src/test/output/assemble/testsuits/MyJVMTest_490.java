import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_490 {

    void fooVoid() {
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_490().fooVoid();
    }
}
