import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_3364 {

    void foo() {
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3364().foo();
    }
}
