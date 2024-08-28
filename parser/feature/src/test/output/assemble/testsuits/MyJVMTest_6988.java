import java.util.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

public class MyJVMTest_6988 {

    static String msg = "dH&MGF^l^z";

    String fail(String msg) {
        System.err.println(msg);
        throw new RuntimeException();
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6988().fail(msg);
    }
}
