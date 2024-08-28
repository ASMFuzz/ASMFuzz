import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_9526 {

    void bar() {
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9526().bar();
    }
}
