import java.util.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

public class MyJVMTest_16502 {

    static String msg = "~EDwv6#w?+";

    String fail(String msg) {
        System.err.println(msg);
        throw new RuntimeException();
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16502().fail(msg);
    }
}
