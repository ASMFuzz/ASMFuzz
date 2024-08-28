import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_12693 {

    void foo() {
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12693().foo();
    }
}
