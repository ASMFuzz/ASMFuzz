import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;

public class MyJVMTest_14970 {

    void nestedBar() {
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14970().nestedBar();
    }
}
