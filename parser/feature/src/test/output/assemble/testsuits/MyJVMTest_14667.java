import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_14667 {

    static String name = "`q>582\\?)}";

    static int method = 8;

    static byte[] data = {-94,90,-127,42,-33,120,-69,-58,-58,-47};

    static byte[] extra = {-31,-79,31,33,-31,-119,-79,58,14,41};

    static String comment = "[0r2%pKqK4";

    static int uniquifier = 86;

    String uniquify(String name) {
        return name + (uniquifier++);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14667().uniquify(name));
    }
}
